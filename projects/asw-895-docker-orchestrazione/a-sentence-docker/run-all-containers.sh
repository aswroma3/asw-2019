#!/bin/bash

docker network create sentence-net 

docker run -d --network=sentence-net --name=eureka eureka-img 

docker run -d --network=sentence-net -e "SPRING_PROFILES_ACTIVE=subject" --name=subject word-img 
docker run -d --network=sentence-net -e "SPRING_PROFILES_ACTIVE=verb" --name=verb word-img -jar -Dspring.profiles.active=verb word.jar
docker run -d --network=sentence-net -e "SPRING_PROFILES_ACTIVE=object" --name=object word-img -jar -Dspring.profiles.active=object word.jar

docker run -d --network=sentence-net --name=sentence sentence-img 

docker run -d --network=sentence-net -p 8080:8080 --name=zuul zuul-img 





