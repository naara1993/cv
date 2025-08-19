# Fase de construcción
FROM eclipse-temurin:17-jdk-alpine as build

# Configurar variables de entorno para la codificación
ENV LANG C.UTF-8
ENV LC_ALL C.UTF-8

WORKDIR /workspace/app

# Copiar solo lo necesario para construir
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Dar permisos de ejecución al mvnw
RUN chmod +x mvnw

# Construir la aplicación
RUN ./mvnw clean package -DskipTests

# Fase de producción
FROM eclipse-temurin:17-jre-alpine
VOLUME /tmp
WORKDIR /app

# Copiar el jar construido
COPY --from=build /workspace/app/target/*.jar app.jar

# Exponer el puerto
EXPOSE 8080

# Punto de entrada
ENTRYPOINT ["java", "-jar", "app.jar"]