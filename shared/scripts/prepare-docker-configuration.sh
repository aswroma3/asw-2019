#!/bin/bash

source "/home/asw/shared/scripts/common.sh"

#
# copia i file HOSTS.CONF e DAEMON.JSON per sovrascrivere la configurazione di docker 
# - il primo, per abilitare la comunicazione remota del nodo 
# - il secondo, per abilitare my-registry:5000 e swarm.inf.uniroma3.it:5000 come registry insicuri 
# 

# copia /etc/systemd/system/docker.service.d/hosts.conf
mkdir -p /etc/systemd/system/docker.service.d
cp ${ASW_RESOURCES}/docker.service.d/hosts.conf /etc/systemd/system/docker.service.d/hosts.conf
chmod a-x /etc/systemd/system/docker.service.d/hosts.conf

# copia /etc/docker/daemon.json 
mkdir -p /etc/docker
cp ${ASW_RESOURCES}/etc.docker/daemon.json /etc/docker/daemon.json
chmod a-x /etc/docker/daemon.json