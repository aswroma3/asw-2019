#!/bin/bash

# itera la richiesta all'infinito 

while true; do 
	curl my-swarm:8080/sentence
	echo "" ; 
done 
