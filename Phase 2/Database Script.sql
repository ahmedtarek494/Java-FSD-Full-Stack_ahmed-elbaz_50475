CREATE DATABASE learn;


use learn;

CREATE TABLE Teachers (
    ID int NOT NULL AUTO_INCREMENT,
    Name varchar(255),
    age int,
	PRIMARY KEY (ID)
);

insert into Teachers(name,age) values ('ahmed',30);

insert into Teachers(name,age) values ('mohamed',34);

insert into Teachers(name,age) values ('karim',45);


CREATE TABLE Subject (
    ID int NOT NULL AUTO_INCREMENT,
    Name varchar(255),
    Level varchar(255),
	PRIMARY KEY (ID)
);

CREATE TABLE Student (
    ID int NOT NULL AUTO_INCREMENT,
    Name varchar(255),
    Grade varchar(255),
	ClassID int,
	PRIMARY KEY (ID)
);

CREATE TABLE Class (
    ID int NOT NULL AUTO_INCREMENT,
    Name varchar(255),
    TeacherID int,
	SubjectID int,
	PRIMARY KEY (ID)
);


ALTER TABLE Student
ADD FOREIGN KEY (ClassID) REFERENCES Class(ID);

ALTER TABLE Class
ADD FOREIGN KEY (TeacherID) REFERENCES Teachers(ID);

ALTER TABLE Class
ADD FOREIGN KEY (SubjectID) REFERENCES Subject(ID);
