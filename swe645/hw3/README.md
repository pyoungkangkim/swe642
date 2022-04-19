# Homework 3 SWE645


## Part 1


## Set up database
```
sudo mysql -u root -p
CREATE DATABASE swe;
CREATE USER 'p'@'localhost' IDENTIFIED WITH mysql_native_password BY 'mypass';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, INDEX, DROP, ALTER, CREATE TEMPORARY TABLES, LOCK TABLES ON swe.* TO 'p'@'localhost';
create 
```
## Setup RDS
```
steps and then in security groups
add an inbound rule to allow all traffic from source 0.0.0.0/0

```

## Build docker image and upload to ECR

1. Build the docker images
    - cd into angular-survey
    - ```docker build -t hw3-ui .```
   - cd into devops_backend
   - ```docker build -t hw3-backend .```

2. Create an AWS ECR Respository and upload to it
    - ```aws ecr create-repository --repository-name hw3-backend --region us-east-1```
    - ```aws ecr get-login-password --region us-east-1 > ecr_pass.txt```
    - ```cat ecr_pass.txt | docker login -u AWS --password-stdin 800617640166.dkr.ecr.us-east-1.amazonaws.com/hw3-backend```
    - ```docker tag hw3-backend:latest 800617640166.dkr.ecr.us-east-1.amazonaws.com/hw3-backend:latest```
    - ```docker push 800617640166.dkr.ecr.us-east-1.amazonaws.com/hw3-backend:latest```
      
    - ```aws ecr create-repository --repository-name hw3-ui --region us-east-1```
    - ```aws ecr get-login-password --region us-east-1 > ecr_pass.txt```
    - ```cat ecr_pass.txt | docker login -u AWS --password-stdin 800617640166.dkr.ecr.us-east-1.amazonaws.com/hw3-ui```
    - ```docker tag hw3-ui:latest 800617640166.dkr.ecr.us-east-1.amazonaws.com/hw3-ui:latest```
    - ```docker push 800617640166.dkr.ecr.us-east-1.amazonaws.com/hw3-ui:latest```
