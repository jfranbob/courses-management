# ============================
# Stage 1: Build the application
# ============================
FROM eclipse-temurin:25-jdk AS builder
WORKDIR /app
COPY . .
RUN ./mvnw -B -pl boot -am package -DskipTests

# ============================
# Stage 2: Run the application
# ============================
FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=builder /app/boot/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
