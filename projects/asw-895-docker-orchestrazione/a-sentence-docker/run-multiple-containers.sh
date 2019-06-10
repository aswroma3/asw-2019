#!/bin/bash

docker network create sentence-net 

# esegue piu' container di ogni tipo (tranne eureka e zuul) 

docker run -d --network=sentence-net --name=eureka eureka-img 

docker run -d --network=sentence-net -e "SPRING_PROFILES_ACTIVE=subject" --name=subject-1 word-img
docker run -d --network=sentence-net -e "SPRING_PROFILES_ACTIVE=subject" --name=subject-2 word-img
docker run -d --network=sentence-net -e "SPRING_PROFILES_ACTIVE=verb" --name=verb-1 word-img
docker run -d --network=sentence-net -e "SPRING_PROFILES_ACTIVE=verb" --name=verb-2 word-img
docker run -d --network=sentence-net -e "SPRING_PROFILES_ACTIVE=object" --name=object-1 word-img
docker run -d --network=sentence-net -e "SPRING_PROFILES_ACTIVE=object" --name=object-2 word-img

docker run -d --network=sentence-net --name=sentence-1 sentence-img 
docker run -d --network=sentence-net --name=sentence-2 sentence-img 

docker run -d --network=sentence-net -p 8080:8080 --name=zuul zuul-img 





