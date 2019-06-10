#!/bin/bash

# da eseguire sul nodo workstation 
# per creare uno swarm composto da un solo nodo 

echo "Creating swarm on workstation" 

# calcola il mio indirizzo IP (sulla rete 10.11.1.xx)
# Ubuntu 16.04 
# MY_IP_ADDR=$(ifconfig  | grep 'inet addr:'| grep -v '127.0.0.1' | cut -d: -f2 | awk '{ print $1}' | grep '10.11.1.')
# Ubuntu 18.04 
MY_IP_ADDR=$(ifconfig  | grep 'inet' | grep -v 'inet6' | grep -v '127.0.0.1' | cut -d: -f2 | awk '{ print $2}' | grep '10.11.1.')

docker swarm init --advertise-addr ${MY_IP_ADDR}

SWARM_TOKEN=$(docker swarm join-token -q worker)
SWARM_MASTER=$(docker info --format "{{.Swarm.NodeAddr}}")

echo "Swarm master: ${SWARM_MASTER}"
echo "Swarm token: ${SWARM_TOKEN}"

# echo "Adding swarm-2 and swarm-3" 
# docker --host 10.11.1.72:2375 swarm join --token ${SWARM_TOKEN} ${SWARM_MASTER}:2377
# docker --host 10.11.1.73:2375 swarm join --token ${SWARM_TOKEN} ${SWARM_MASTER}:2377