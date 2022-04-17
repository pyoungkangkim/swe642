# Homework 1 SWE645


## Part 1
### S3 URL

* http://pkim23-swe645-public.s3-website-us-east-1.amazonaws.com/
  * if you want to try the error page, please hit http://pkim23-swe645-public.s3-website-us-east-1.amazonaws.com/asdf

## Part 2

### EC2's tomcat's Student Survey URL

* http://ec2-54-157-41-151.compute-1.amazonaws.com/part2-1.0-SNAPSHOT/survey_page.html

### Installation and Setup/Process 
#### For local deployment
```
cd part2
mvn clean install
cp target/part2-1.0-SNAPSHOT.war /opt/tomcat/webapps
cd /opt/tomcat/bin
./startup.sh
sleep 30
curl http://localhost:8080/part2-1.0-SNAPSHOT/survey_page.html
```
#### For AWS EC2(Bitnami Tomcat) deployment

* First go to EC2 console and launch a Tomcat certified by Bitnami Instance and obtain a your_ssh_rsa.pem
* In the EC2 console, click on Elastic IPs under Network & Security section in the lefthand side of the webpage
* Allocate an Elastic IP Address
* In the running instance, allocate the Elastic IP address for it so it stays static upon restarts of the instance
  * You will need this to login and access the url
  * This README.md assumes your IP is 54.157.41.151

##### Now shell commands to run the application

```
cd part2
scp -i your_ssh_rsa.pem -rp part2 bitnami@54.157.41.151:/home/bitnami
ssh -i 'your_ssh_rsa.pem' bitnami@54.157.41.151
sudo apt install maven -y
cd part2
mvn clean install
cp target/part2-1.0-SNAPSHOT.war /opt/bitnami/tomcat/webapps
cd /opt/bitnami/tomcat/bin
./startup.sh
curl http://localhost:8080/part2-1.0-SNAPSHOT/survey_page.html
```

#### you can then log out of the EC2 and access the url through 
http://ec2-54-157-41-151.compute-1.amazonaws.com/part2-1.0-SNAPSHOT/survey_page.html
