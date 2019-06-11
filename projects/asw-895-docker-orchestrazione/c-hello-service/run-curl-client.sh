#!/bin/bash

# DOCKER_SWARM_HOST=localhost
DOCKER_SWARM_HOST=workstation

# itera la richiesta 100 volte 

for i in {1..100}; do 
	curl ${DOCKER_SWARM_HOST}:8080
	echo "" ; 
done 
