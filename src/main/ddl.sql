DROP table Person;
DROP table Students;
CREATE TABLE Person(
                       id int PRIMARY KEY,
                       name varchar(100) NOT NULL,
                       age int,
                       email varchar(100)
);

INSERT INTO person (name, age, email) VALUES ('Taras',23,'rar@gmail.com');
INSERT INTO person (name, age, email) VALUES ('Grigoriy',33,'grigoriy@gmail.com');
INSERT INTO person (name, age, email) VALUES ('Paraska',77,'babka@gmail.com');

CREATE TABLE Student(
                       id int PRIMARY KEY,
                       name varchar(100) NOT NULL,
                       lastname varchar(100) NOT NULL,
                       age int,
                       phone varchar(15) NOT NULL,
                       email varchar(100)
);
