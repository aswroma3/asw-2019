#!/bin/bash

# itera la richiesta all'infinito 

while true; do 
	curl localhost:8080/sentence
	echo "" ; 
done 
