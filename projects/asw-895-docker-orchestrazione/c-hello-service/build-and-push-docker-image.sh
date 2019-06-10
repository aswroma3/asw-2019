#!/bin/bash

# per creare l'immagine docker e salvarla su docker hub 

# prerequisito: aver eseguito il docker login su docker hub 

DOCKERHUB_USERNAME=aswroma3 

docker build --rm -t ${DOCKERHUB_USERNAME}/hello . 
docker push ${DOCKERHUB_USERNAME}/hello

