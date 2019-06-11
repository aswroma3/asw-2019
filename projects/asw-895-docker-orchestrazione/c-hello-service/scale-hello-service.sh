#!/bin/bash

# per scalare un servizio in esecuzione in uno swarm

# DOCKER_SWARM=tcp://localhost:2375
DOCKER_SWARM=tcp://workstation:2375

docker -H ${DOCKER_SWARM} service scale hello=4
