# Usa una imagen más compatible
FROM eclipse-temurin:17-jdk-alpine as builder

# Configura variables de entorno
ENV LANG C.UTF-8
ENV LC_ALL C.UTF-8
ENV JAVA_TOOL_OPTIONS="-Dfile.encoding=UTF-8"

WORKDIR /app

# Copia los archivos necesarios (primero los que cambian menos)
COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .

# Da permisos de ejecución al mvnw ANTES de usarlo
RUN chmod +x mvnw

# Copia el código fuente
COPY src src

# Construye el proyecto
RUN ./mvnw clean package -DskipTests

# Imagen final más ligera
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copia el jar
COPY --from=builder /app/target/*.jar app.jar

# Expone el puerto
EXPOSE 8080

# Ejecuta la app
ENTRYPOINT ["java", "-jar", "app.jar"]