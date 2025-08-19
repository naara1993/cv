# Usa una imagen más compatible
FROM eclipse-temurin:17-jdk-alpine as builder

# Configura variables de entorno
ENV LANG C.UTF-8
ENV LC_ALL C.UTF-8

WORKDIR /app

# Copia los archivos necesarios
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Da permisos y construye
RUN chmod +x mvnw && \
    ./mvnw clean package -DskipTests

# Imagen final más ligera
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copia el jar
COPY --from=builder /app/target/*.jar app.jar

# Expone el puerto
EXPOSE 8080

# Ejecuta la app
ENTRYPOINT ["java", "-jar", "app.jar"]