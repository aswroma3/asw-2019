#!/bin/bash

echo 'Starting sentence application as a stack' 

# DOCKER_SWARM=tcp://localhost:2375
DOCKER_SWARM=tcp://workstation:2375

docker -H ${DOCKER_SWARM} stack deploy --compose-file docker-compose.yml sentence

