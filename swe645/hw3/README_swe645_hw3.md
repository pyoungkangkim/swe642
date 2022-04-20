# Homework 3 SWE645

## Prerequisites for a ubuntu instance
### Set up docker, kubectl, AWS CLI & IAM Authenticator, eksctl
0. Install Ubuntu instance

1. docker -https://docs.docker.com/get-docker/
   - ```sudo apt-get update```
   - ```sudo apt-get install ca-certificates curl gnupg lsb-release```
   - ```curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg```
   - ```echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null```
   - ```sudo apt-get update```
   - ```sudo apt-get install docker-ce docker-ce-cli containerd.io```
   - ```sudo groupadd docker```
   - ```sudo gpasswd -a $USER docker```

2. Kubectl installation from https://www.coachdevops.com/2020/10/install-kubectl-on-ubuntu-instance-how.html
   - ```curl -s https://packages.cloud.google.com/apt/doc/apt-key.gpg | sudo apt-key add -```
   - ```sudo touch /etc/apt/sources.list.d/kubernetes.list```
   - ```echo "deb http://apt.kubernetes.io/ kubernetes-xenial main" | sudo tee -a /etc/apt/sources.list.d/kubernetes.list```
   - ```sudo apt-get update```
   - ```sudo apt-get install -y kubectl```

3. AWS CLI
   - first create an account for AWS and a user
   - https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html
      - ```curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"```
      - ```unzip awscliv2.zip```
      - ```sudo ./aws/install```
      - ```./aws/install -i /usr/local/aws-cli -b /usr/local/bin```
      - log into aws console and create a user with administrator access and download the new_user_credentials.csv
      - https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-configure.html
      - ```cd ~/.aws```
   - log into aws console and create a user with administrator access and download the new_user_credentials.csv
   - create a file called credentials looking like this - fill in from new_user_credentials.csv
        ```
        [default]
        aws_access_key_id = your-key-id
        aws_secret_access_key your-secret-access-key
        ```
   - create another file called config
       ```
       [default]
       region = us-east-1
       output = json
       ```

4. Aws IAM authenticator -https://docs.aws.amazon.com/eks/latest/userguide/install-aws-iam-authenticator.html
   - ```curl -o aws-iam-authenticator https://amazon-eks.s3.us-west-2.amazonaws.com/1.21.2/2021-07-05/bin/linux/amd64/aws-iam-authenticator```
   - ```chmod +x ./aws-iam-authenticator```
   - ```mkdir .is```
   - ```cp ./aws-iam-authenticator $HOME/.aws-iam-authenticator```
   - ```echo 'export PATH=$PATH:$HOME/.is' >> ~/.bashrc```
   - ```aws-iam-authenticator help```

5. eksctl -https://github.com/weaveworks/eksctl
   - ```curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp```
   - ```sudo mv /tmp/eksctl /usr/local/bin```

## Setup RDS
1. Use the console to create standard
   - select mysql
   - select default options, however 
      - change the database name to swe
      - select 'p' for username and 'mypassword' for password
      - select public networking

2. set up security group to allow traffic from backend
   - select the security group named 'default' in SecurityGroups page
   - edit inbound rules 
      - assign a rule that allows all traffic from source 0.0.0.0/0

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

## Build docker image and upload to ECR

1. Build the docker images
    - cd into devops_backend
    - ```docker build -t hw3-backend .```
    - the demo-0.0.1-SNAPSHOT.jar was created from ```mvn clean install``` inside the backend directory

2. Create an AWS ECR Respository and upload to it
    - ```aws ecr create-repository --repository-name hw3-backend --region us-east-1```
    - ```aws ecr get-login-password --region us-east-1 > ecr_pass.txt```
    - ```cat ecr_pass.txt | docker login -u AWS --password-stdin 800617640166.dkr.ecr.us-east-1.amazonaws.com/hw3-backend```
    - ```docker tag hw3-backend:latest 800617640166.dkr.ecr.us-east-1.amazonaws.com/hw3-backend:latest```
    - ```docker push 800617640166.dkr.ecr.us-east-1.amazonaws.com/hw3-backend:latest```

# deploy the backend

0. Create a user <your_username> for EKS
    - grant AdministratorAccess role

1. run ```eksctl create cluster -f hw3-backend-cluster.yaml``` inside devops_backend
    - check if the cluster is up ```kubectl get svc```
    - check namespaces ```kubectl get pods --all-namespaces -o wide```

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

- https://www.youtube.com/watch?v=dkLlDG8vmhA

## AWS homepage link below

- http://pkim23-swe645-public.s3-website-us-east-1.amazonaws.com/

## As required from the submission, although not live, but shown in the video
### frontend
- http://a24d775d4e7ca402c8a2880e1b1032e7-319553540.us-east-1.elb.amazonaws.com/
- http://a24d775d4e7ca402c8a2880e1b1032e7-319553540.us-east-1.elb.amazonaws.com/allSurveys
- http://a24d775d4e7ca402c8a2880e1b1032e7-319553540.us-east-1.elb.amazonaws.com/survey

### backend
- http://a47bf37c0a70f4a5eba390eea8c3675b-1557363398.us-east-1.elb.amazonaws.com/api/survey
