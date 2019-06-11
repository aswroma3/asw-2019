#!/bin/bash

# per arrestare l'esecuzione come servizio in uno swarm  

# DOCKER_SWARM=tcp://localhost:2375
DOCKER_SWARM=tcp://workstation:2375

docker -H ${DOCKER_SWARM} service rm hello 
