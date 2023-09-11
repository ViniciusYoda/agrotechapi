#Build Stage
FROM ringcentral/maven:3.8.2-jdk17 as build
COPY . .
RUN mvn clean package -DskipTests 
#Package
FROM eclipse-temurin:17-jdk-alpine
COPY --from=build target/agrotechapi-0.0.1-SNAPSHOT.jar /opt/agrotechapi.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/opt/agrotechapi.jar"]