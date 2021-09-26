FROM openjdk:11
COPY src/Main.java .
RUN javac Main.java
CMD ["java", "Main"]


