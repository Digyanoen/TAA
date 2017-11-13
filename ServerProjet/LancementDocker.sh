#!/bin/bash

echo "Lancement du container mysql"
sudo docker run -d --name mysqldb -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=weplannerdb -e MYSQL_USER=dbuser -e MYSQL_PASSWORD=dbpassword mysql:latest && mvn install && echo "DockerBuild" && sudo docker build -t weplanner . && echo "Lancement du container du serveur" && sudo docker run --name weplanner -p 8080:8080 --link mysqldb:mysqldb weplanner