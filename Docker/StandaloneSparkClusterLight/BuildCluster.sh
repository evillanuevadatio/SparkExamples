

 sudo docker-compose stop
 sudo docker-compose rm -f
 sudo docker ps -a
 sudo docker rm 

 sudo docker rmi spark-base-light
 sudo docker rmi spark-master
 sudo docker rmi spark-slave

 sudo docker build -t spark-base-light ./SparkNode/
 sudo docker build -t spark-master ./SparkMaster/
 sudo docker build -t spark-slave ./SparkSlave/
 
 sudo docker-compose up -d
 sudo docker ps 
 sudo docker logs --follow f61ddb60c400

 sudo docker run -it spark-master /bin/bash

 sudo docke inspect --format '{{ .NetworkSettings.IPAddress }}' 4d8c90cbbf7a
 
 sudo docker cp 4d8c90cbbf7a:/ .


