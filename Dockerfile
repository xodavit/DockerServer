FROM maven:3-openjdk-16-slim AS build
WORKDIR /app/build
COPY . .
RUN mvn package -B
RUN mv target/docker-server-1.0-jar-with-dependencies.jar target/app.jar

FROM openjdk:16-slim
WORKDIR /app/bin
COPY --from=build /app/build/target/app.jar .
CMD ["java", "-jar", "app.jar"]



