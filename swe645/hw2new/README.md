# Homework 2 SWE645

## Prerequisites for a ubuntu instance
### Set up docker, kubectl, AWS CLI & IAM Authenticator, eksctl
0. Install Ubuntu instance
   
1. docker -https://docs.docker.com/get-docker/
   - sudo apt-get update
   - sudo apt-get install ca-certificates curl gnupg lsb-release
   - curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg
   - echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
   - sudo apt-get update
   - sudo apt-get install docker-ce docker-ce-cli containerd.io
   - sudo groupadd docker
   - sudo gpasswd -a $USER docker

2. Kubectl installation from https://www.coachdevops.com/2020/10/install-kubectl-on-ubuntu-instance-how.html
    - curl -s https://packages.cloud.google.com/apt/doc/apt-key.gpg | sudo apt-key add -
    - sudo touch /etc/apt/sources.list.d/kubernetes.list
    - echo "deb http://apt.kubernetes.io/ kubernetes-xenial main" | sudo tee -a /etc/apt/sources.list.d/kubernetes.list
    - sudo apt-get update
    - sudo apt-get install -y kubectl

3. AWS CLI
    - first create an account for AWS
    - https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html
        - curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
        - unzip awscliv2.zip
        - sudo ./aws/install
        - ./aws/install -i /usr/local/aws-cli -b /usr/local/bin
        - log into aws console and create a user with administrator access and download the new_user_credentials.csv
        - https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-configure.html
        - cd ~/.aws
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
    - curl -o aws-iam-authenticator https://amazon-eks.s3.us-west-2.amazonaws.com/1.21.2/2021-07-05/bin/linux/amd64/aws-iam-authenticator
    - chmod +x ./aws-iam-authenticator
    - mkdir .is
    - cp ./aws-iam-authenticator $HOME/.aws-iam-authenticator
    - echo 'export PATH=$PATH:$HOME/.is' >> ~/.bashrc
    - aws-iam-authenticator help

5. eksctl -https://github.com/weaveworks/eksctl
    - curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
    - sudo mv /tmp/eksctl /usr/local/bin


## Setup EKS on AWS

1. Create necessary role for EKS
   - 




































































