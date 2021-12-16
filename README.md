# JavaFinal
It is an online reservation program.
This homework is done with IntelliJ. 

My original plan: 
  Frontend: HTML,
  Loadbalancer: Nginx,
  Backend: Java + Springboot,
  Database: Sqlite
  
What I actually did:
  Frontend: HTMP + Vue.js
  Backend: Java + Springboot + Hibernate,
  Database: MySQL

To run this program, you should first install Mysql, then create the schema and table with the following sql command.
CREATE SCHEMA `reservation` ;
create table `reservation`.calendar (id int(11) not null auto_increment, date DATETIME, name varchar(128), password varchar(128), primary key (id));

After you clone this project, you may need to run the Maven to download all the dependencies. 
To modify the MySQL address, username, and password, visit src/main/resources/hibernate.cfg.xml


To start the program, run src/main/java/com.example.javafinal/JavaFinalApplication.java

Then access http://localhost:8080/index.html

This program allow you to schedule through next three days. 
You need a name and password to schedule a date. 
After you schedule a date, you can use your original name and password to unschedule it.
Before and after you do anything, click the refresh button first. 




