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