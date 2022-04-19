# Author: Pyoung Kang Kim
# This is the Dockerfile to run the self contained jar from our backend
FROM adoptopenjdk/openjdk11:latest
RUN mkdir /opt/app
ADD demo-0.0.1-SNAPSHOT.jar /opt/app
EXPOSE 8080
CMD ["java", "-jar", "/opt/app/demo-0.0.1-SNAPSHOT.jar"]