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

> docker login --username sumeetteemus
> docker image ls
> docker image rm image_id or > docker rmi image_id 							(To remove a image using image_id)
> docker image build
	. 											(This loads Dockerfile from current directory)
	-t sumeetteemus/repo1:employee-api_1.1		(This creates tag for image at particular repository for a particular username)
> docker image push sumeetteemus/repo1:employee-api_1.1

Now docker can be run now but if docker image is required to be pulled from hub into other machine then pull the image
> docker pull sumeetteemus/repo1:employee-api_1.1 (To download all tags(-a also works), > docker pull --all-tags sumeetteemus/repo1)

> docker run
	-it									(-i to keep STDIN open even if not attached and -t to allocate a pseudo-tty i.e. terminal to the process)
	-d              					(run in detach mode)
	-p 8081:20000 						(uses port 20000 of container which is mapped to 8081 of external system i.e. this machine)
	--name employee-api_1.1_Container_1 (Name of the container)
	sumeetteemus/repo1:employee-api_1.1 (This is username/repository_name:tagname)
> docker container ps 					(To check the process status of only running container, Now add -a, to check all process status including running/exited container, Now add -f status=exited can be added to check exited container )
> docker logs 98937cc0b2d2				(To check log using container id)
> docker container stop 98937cc0b2d2				(To stop/exit the container, to start again use> docker container start 98937cc0b2d2)
> docker container rm 98937cc0b2d2				(To remove the container)

> docker inspect image_id/image_name	(To get all details of a particular image)
Note: If code has been changes, when code is developed/tested locally. Then image is build and push again with same tag. Other developer needs to take a pull of this image
Expose means exposing outside of container but inside docker only.
-p means exposing outside dockers. Both means everywhere.
Using CMD, we need bash then we can invoke java but using ENTRYPOINT it does all.