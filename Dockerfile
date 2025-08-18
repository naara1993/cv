# Fase de construcción
FROM eclipse-temurin:17-jdk-alpine as build
WORKDIR /workspace/app

# Copiar archivos necesarios
COPY mvnw .
COPY .mvn .mvn
RUN chmod +x mvnw  # Dar permisos de ejecución
COPY pom.xml .
COPY src src

# Construir la aplicación
RUN ./mvnw clean package -DskipTests

# Fase de producción
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /workspace/app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
