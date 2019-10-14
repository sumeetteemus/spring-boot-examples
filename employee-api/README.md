## H2 database
---------------------------------

How to access h2 database
===========================
Go to http://localhost:20000/publicissapient/h2-console and enter datasource as "jdbc:h2:mem:testdb". Then connect.

DROP TABLE IF EXISTS EMPLOYEE;

CREATE TABLE EMPLOYEE(ID INT PRIMARY KEY, USERNAME VARCHAR(255), PASSWORD VARCHAR(255), FIRST_NAME VARCHAR(255), MIDDLE_NAME VARCHAR(255), LAST_NAME VARCHAR(255), EMAIL VARCHAR(255), ADDRESS VARCHAR(255));

INSERT INTO EMPLOYEE VALUES(1, 'sumeetteemus', 'local123', 'Sumeet', '', 'Kumar', 'sumeet.kumar@publicissapient.com', 'bihar');
INSERT INTO EMPLOYEE VALUES(2, 'dipshikha', 'local123', 'Dipshikha', '', 'Ghosh', 'dipshikha.ghosh@accenture.com', 'west bengal');
SELECT * FROM EMPLOYEE ORDER BY ID;

## Swagger2
----------------------------------
How to access swagger2
======================
http://localhost:20000/publicissapient/swagger-ui.html

## Docker Command
======================
> docker image build -t employee-api . (-t means tag by employee-api)
> docker container run --name emp-api-1 -p 8081:20000 -d employee-api
(-p mean port, 20000 is the container's port, 8081 is exposed port, --name is for container name and -d is execute as daemon i.e. background)
