# Homework 3 SWE645

## Setup Mysql Database
1. First install Mysql
   - sudo apt install mysql-server
2. The set up user and database
   - sudo mysql -u root -p
   - CREATE DATABASE swe;
   - CREATE USER 'p'@'localhost' IDENTIFIED WITH mysql_native_password BY 'mypass';
   - GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, INDEX, DROP, ALTER, CREATE TEMPORARY TABLES, LOCK TABLES ON swe.* TO 'p'@'localhost';

# set up the backend Spring boot project

1. Create a spring boot project using https://start.spring.io/
   - include WEB(for restful services), JPA(for database manipulation) and Lombok(easy of data object creation)
   - Or alternatively, just copy the pom.xml file in the backend project in this repository, this will have all the necessary dependencies
   
2. 

## Create the EKS deployment

1. run ```kubectl apply -f hw3-backend-deployment.yaml```
2. check to see if it's up ```kubectl get deployments```

## Create LB service for external communication

1. run ```kubectl apply -f hw3-backend-lb-service.yaml```
2. run below and record the external-ip of the service/hw3-backend-lb
    - ```kubectl get all```
3. curl the <external-ip-link>/demo-0-0.1-SNAPSHOT/api/survey
    - for example http://ade3d3fbcbc11427e95e402c07f57bce-1621615609.us-east-1.elb.amazonaws.com/demo-0-0.1-SNAPSHOT/api/survey

# deploy the frontend

## Build docker image and upload to ECR

1. Build the docker images
   - cd into angular-survey
   - ```docker build -t hw3-ui .```

2. Create an AWS ECR Respository and upload to it
   - ```aws ecr create-repository --repository-name hw3-ui --region us-east-1```
   - ```aws ecr get-login-password --region us-east-1 > ecr_pass.txt```
   - ```cat ecr_pass.txt | docker login -u AWS --password-stdin 800617640166.dkr.ecr.us-east-1.amazonaws.com/hw3-ui```
   - ```docker tag hw3-ui:latest 800617640166.dkr.ecr.us-east-1.amazonaws.com/hw3-ui:latest```
   - ```docker push 800617640166.dkr.ecr.us-east-1.amazonaws.com/hw3-ui:latest```


0. Create a user <your_username> for EKS
    - grant AdministratorAccess role

1. run ```eksctl create cluster -f hw3-ui-cluster.yaml``` inside devops_ui
    - check if the cluster is up ```kubectl get svc```
    - check namespaces ```kubectl get pods --all-namespaces -o wide```

## Create the EKS deployment

1. run ```kubectl apply -f hw3-ui-deployment.yaml```
2. check to see if it's up ```kubectl get deployments```

## Create LB service for external communication

1. run ```kubectl apply -f hw3-ui-lb-service.yaml```
2. run below and record the external-ip of the service/hw3-ui-lb
    - ```kubectl get all```
3. curl the <external-ip-link>


## Finally, cleanup
1. ```kubectl delete service/hw3-ui-lb```
2. ```eksctl delete cluster --name hw3-ui-cluster```
3. ```kubectl delete service/hw3-backend-lb```
4. ```eksctl delete cluster --name hw3-backend-cluster```


## Video Link below

- https://www.youtube.com/watch?v=h0CPV2uaTsU


## AWS homepage link below

- http://pkim23-swe645-public.s3-website-us-east-1.amazonaws.com/


































