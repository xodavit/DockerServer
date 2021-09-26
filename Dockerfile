FROM openjdk:11 AS build
COPY src/Main.java .
RUN javac Main.java

FROM openjdk:11
COPY --from=build Main.class .
CMD ["java", "Main"]


