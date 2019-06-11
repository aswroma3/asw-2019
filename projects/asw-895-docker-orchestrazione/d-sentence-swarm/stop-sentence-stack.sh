#!/bin/bash

echo 'Halting sentence application as a stack' 

# DOCKER_SWARM=tcp://localhost:2375
DOCKER_SWARM=tcp://workstation:2375

docker -H ${DOCKER_SWARM} stack rm sentence
