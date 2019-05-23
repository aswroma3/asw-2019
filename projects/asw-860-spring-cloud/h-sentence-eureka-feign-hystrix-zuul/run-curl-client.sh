#!/bin/bash

# itera la richiesta 100 volte 

for i in {1..100}; do 
	curl localhost:8080/sentence
	echo "" ; 
done 
