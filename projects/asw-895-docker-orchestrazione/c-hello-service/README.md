# Hello (con Docker in modalità swarm)

Questo sottoprogetto esemplifica come eseguire una semplice applicazione web Spring Boot 
come **servizio Docker** usando **Docker** in modalità **swarm**. 

## Componenti eseguibili

Questa applicazione **hello** è formata da un solo componente eseguibile.

## Ambiente di esecuzione 

Questa applicazione può essere costruita ed eseguita nell'ambiente [workstation](../../environments/workstation/), sul nodo **workstation**. 
Vanno però utilizzate più finestre (terminali) diverse. In genere, una per l'applicazione ed una per il suo client.  

## Inizializzazione dello swarm 

Viene utilizzato uno swarm formato da un solo nodo (che agisce sia come manager che come worker). 

Per inizializzare lo swarm (se non è stato ancora mai fatto) sul nodo **workstation**: 

* eseguire il comando `docker swarm init`

* in alternativa, eseguire lo script `/home/asw/shared/scripts/start-mini-swarm.sh`

## Build (Java) - OPZIONALE 

Per la costruzione dell'applicazione, eseguire il comando `gradle assemble` oppure `gradle build`

## Build (Docker) - OPZIONALE 

*Questo passo è necessario solo se si vogliono utilizzare delle immagini Docker diverse da quelle predisposte dal docente del corso.*

Per la costruzione delle immagini Docker ed effettuare il push su Docker Hub: 

* accedere a Docker Hub, eseguendo il comando `docker login` (è necessaria la registrazione a Docker Hub)

* modificare i file `build-and-push-docker-image.sh` e `run-hello-service.sh`, usando il nome del proprio account su Docker Hub al posto di **aswroma3** 

* eseguire lo script `build-and-push-docker-image.sh` 

## Esecuzione 

Per avviare l'applicazione sul nodo **workstation**, eseguire lo script `run-hello-service.sh`. 
Se si vuole avviare l'applicazione in uno *swarm* diverso, è necessario prima modificare la variabile d'ambiente `DOCKER_SWARM` negli script `run-hello-service.sh`, `stop-hello-service.sh`, `run-curl-client.sh` e `run-curl-client-forever.sh`. 

Complessivamente, l'applicazione *hello* espone un servizio REST sulla porta **8080** del nodo **workstation**, 
ed è possibile ottenere un saluto all'indirizzo `workstation:8080`.

In pratica, l'applicazione può essere verificata usando lo script `run-curl-client.sh` oppure `run-curl-client-forever.sh` (alla fine va arrestato con **CTRL-C**). 

## Arresto 

Per arrestare l'applicazione, eseguire lo script `stop-hello-service.sh` 





