# Homework 3 SWE645

## Setup Mysql Database
1. First install Mysql
   - sudo apt install mysql-server
2. The set up user and database
   - sudo mysql -u root -p
   - CREATE DATABASE swe;
   - CREATE USER 'p'@'localhost' IDENTIFIED WITH mysql_native_password BY 'mypass';
   - GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, INDEX, DROP, ALTER, CREATE TEMPORARY TABLES, LOCK TABLES ON swe.* TO 'p'@'localhost';

## set up the backend Spring boot project

1. Create a spring boot project using https://start.spring.io/
   - include Spring Web(for restful services), JPA(for java persistence api and hibernate) and Lombok(basic object methods)
   - Or alternatively, just copy the pom.xml file in the backend project in this repository, this will have all the necessary dependencies
   
2. Write the backend code
   - go over in the video
   
## set up the angular project

1. Install nodejs from https://nodejs.org/en/download/
2. run ``` npm i @angular/cli ```
3. run ```ng new angular-survey``` this generates a new angular starter project
4. to add components run ```ng generate <some-component>```
5. some other dependencies you need is specified in the components, for example you'll need to run
   - ```npm install @angular/http```
6. others will be covered in video as it is too much to go over all the source code

## Run the backend
1. In the backend project
   - run ```mvn clean install```
   - run ```java -jar target/demo-0.0.1-SNAPSHOT.jar```
   
## Run the front end
1. In the angular-survey project
   - run ```npm i```
   - run ```ng serve --open```

## Video Link below for this SWE642 version

- https://youtu.be/SZk6aCnWJvE


## For the full fleged deployment with EKS and docker on AWS version  for SWE645

- https://github.com/pyoungkangkim/swe/blob/main/README_swe645_hw3.md
- https://www.youtube.com/watch?v=dkLlDG8vmhA



























