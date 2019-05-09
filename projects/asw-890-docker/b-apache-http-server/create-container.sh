#!/bin/bash

docker create -v ~/projects/asw-890-docker/www:/var/www/html -p 8080:80 --name=apache apache-img 
