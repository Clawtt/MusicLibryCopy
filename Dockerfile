FROM maven:3.6.3-openjdk-17-slim AS MAVE_BUILD
COPY . /
RUN mvn clean package

FROM openjdk:23-slim-bullseye
EXPOSE 8080
COPY --from=MAVE_BUILD target/MusicLibryCopy-*.jar /app.jar
ENTRYPOINT ["java","-jar","app.jar"]