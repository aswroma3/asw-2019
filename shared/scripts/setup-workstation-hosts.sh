#!/bin/bash

HOSTS_FILE=/etc/hosts 

# aggiunge un # all'inizio delle linee che iniziano con 127.0.0.1 e 127.0.1.1 
function createModifiedHostsFile
{
	echo "modifying 127.0.x.x entries in /etc/hosts"
	# Legge il file $INFILE e lo copia in $OUTFILE, ma: 
	# - aggiunge un # all'inizio delle linee che iniziano con 127.0. 
	sed s/^'127.0.'/'# 127.0.'/ ${HOSTS_FILE} > ${HOSTS_FILE}.new
	# aggiunge di nuovo 127.0.0.1 localhost
    echo "127.0.0.1 localhost" >> ${HOSTS_FILE}.new 
	mv ${HOSTS_FILE} ${HOSTS_FILE}.bak
	mv ${HOSTS_FILE}.new ${HOSTS_FILE}
}

# aggiunge a /etc/hosts le seguenti entry 
# - "10.11.1.61 workstation my-swarm my-registry"
#
# in teoria, my-swarm e my-registry dovrebbero essere serviti da un DNS, 
# a rotazione su uno qualunque di questi nodi 
# in pratica, facendo così, my-swarm e my-registry coincidono con workstation
#
function setupSwarmHostsFile {
	# calcola il mio indirizzo IP (sulla rete 10.11.1.xx)
	# ubuntu 16.04 
	# MY_IP_ADDR=$(ifconfig  | grep 'inet addr:'| grep -v '127.0.0.1' | cut -d: -f2 | awk '{ print $1}' | grep '10.11.1.')
	# ubuntu 18.04 
	MY_IP_ADDR=$(ifconfig  | grep 'inet' | grep -v 'inet6' | grep -v '127.0.0.1' | cut -d: -f2 | awk '{ print $2}' | grep '10.11.1.')
	echo "adding entries for swarm nodes to /etc/hosts on " ${MY_IP_ADDR}
	# echo ${MY_IP_ADDR} " workstation my-swarm my-registry" >> ${HOSTS_FILE}
	echo ${MY_IP_ADDR} " workstation" >> ${HOSTS_FILE}
}

echo "setup /etc/hosts on the workstation node"
createModifiedHostsFile
setupSwarmHostsFile