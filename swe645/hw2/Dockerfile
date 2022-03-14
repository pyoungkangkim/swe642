# Author: Pyoung Kang Kim
# This is the Dockerfile to build the tomcat image with my hw2 app in it
FROM bitnami/tomcat
ADD hw2-version1.war /opt/bitnami/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]

