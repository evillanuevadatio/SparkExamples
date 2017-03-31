# Usar Docker compose para generar un cluster Spark standalone

#### Requerimientos

###### Se necesita tener instalado docker, docker-compose

``` 
> sudo docker -v
    Docker version 17.03.0-ce, build 3a232c8
``` 
##### Docker Compose
###### La instalación del docker compose puede variar con respecto al SO
###### https://docs.docker.com/compose/install/ 

``` 
> sudo docker-compose version
    docker-compose version 1.11.2, build dfed245
    docker-py version: 2.1.0
    CPython version: 2.7.13
    OpenSSL version: OpenSSL 1.0.1t  3 May 2016
``` 

#### Construir imagenes 


``` 
> sudo docker build -t spark-base-light ./SparkNode/
> sudo docker build -t spark-mastert ./SparkMaster
> sudo docker build -t spark-slave ./SparkSlave/

``` 

#### Levantar el cluster

``` 
> sudo docker-compose up -d
``` 

#### Parar el cluster

``` 
> sudo docker-compose stop
``` 

#### Reiniciar el cluster

``` 
> sudo docker-compose restart
``` 

#### Eliminar containers generados

``` 
> sudo docker-compose rm -f
``` 

#### Escalar  containers ( slaves

``` 
> sudo docker-compose scale spark-slave=2
``` 











