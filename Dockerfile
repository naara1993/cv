# Fase de construcción
FROM eclipse-temurin:17-jdk-alpine as build
WORKDIR /workspace/app

# Copiar solo lo necesario para construir
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Construir la aplicación
RUN ./mvnw clean package -DskipTests

# Fase de producción
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
WORKDIR /app
COPY --from=build /workspace/app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]