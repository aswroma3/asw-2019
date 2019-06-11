#!/bin/bash

# DOCKER_SWARM_HOST=localhost
DOCKER_SWARM_HOST=workstation

# itera la richiesta all'infinito 

while true; do 
	curl ${DOCKER_SWARM_HOST}:8080/sentence
	echo "" ; 
done 
