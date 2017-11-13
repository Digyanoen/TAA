FROM java:8
WORKDIR /app
ADD target/spring-boot-sample-data-jpa-1.4.0.RELEASE.jar /app
ADD src/main/resources/city.smalllist.json /app
EXPOSE 80
CMD ["java",  "-jar", "spring-boot-sample-data-jpa-1.4.0.RELEASE.jar"]

