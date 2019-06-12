# Sentence (con Docker in modalità swarm)

Questo sottoprogetto mostra come eseguire una versione dell'applicazione **sentence** usando *Docker* in modalità *swarm*. 

## Componenti eseguibili

Questa versione dell'applicazione **sentence** è formata dai seguenti componenti eseguibili: 

* **word-service** è il servizio per la generazione di parole casuali, che viene avviato con tre istanze: 
  * una con il profilo *subject* su una porta casuale, 
  * una con il profilo *verb* su una porta casuale, 
  * una con il profilo *object* su una porta casuale, 
* **sentence-service** è il servizio per la generazione delle frasi casuali, su una porta casuale, che agisce da client nei confronti dei servizi per le parole tramite Feign e Hystrix 
* **zuul-gateway** è un API gateway per esporre le funzionalità dell'intera applicazione sulla porta *8080* 

## Ambiente di esecuzione 

Questa applicazione può essere costruita ed eseguita nell'ambiente [workstation](../../environments/workstation/), sul nodo **workstation**. 
Vanno però utilizzate più finestre (terminali) diverse. In genere, una per l'applicazione ed una per il suo client.  

## Inizializzazione dello swarm 

Viene utilizzato uno swarm formato da un solo nodo (che agisce sia come manager che come worker). 

Per inizializzare lo swarm (se non è stato ancora mai fatto) sul nodo **workstation**: 

* eseguire il comando `docker swarm init`

* in alternativa, eseguire lo script `/home/asw/shared/scripts/start-mini-swarm.sh`

## Build (Java) - OPZIONALE 

*Questo passo è necessario solo se si vogliono utilizzare delle immagini Docker diverse da quelle predisposte dal docente del corso.*

Per la costruzione dell'applicazione, eseguire il comando `gradle assemble` oppure `gradle build`, oppure eseguire lo script `build-java-projects.sh`

## Build (Docker) - OPZIONALE 

*Questo passo è necessario solo se si vogliono utilizzare delle immagini Docker diverse da quelle predisposte dal docente del corso.*

Per la costruzione delle immagini Docker ed effettuare il push su Docker Hub: 

* accedere a Docker Hub, eseguendo il comando `docker login` (è necessaria la registrazione a Docker Hub)

* modificare il file `docker compose.yml`, usando il nome del proprio account su Docker Hub al posto di **aswroma3** 

* eseguire lo script `build-and-push-docker-images.sh` 

## Esecuzione 

Per avviare l'applicazione sul nodo **workstation**, eseguire lo script `run-sentence-stack.sh`. 
Se si vuole avviare l'applicazione in uno *swarm* diverso, è necessario prima modificare la variabile d'ambiente `DOCKER_SWARM` negli script `run-sentence-stack.sh`, `stop-sentence-stack.sh` e `run-curl-client-forever.sh`. 

Complessivamente, l'applicazione *sentence* espone un servizio REST sulla porta **8080** del nodo **workstation**, 
ed è possibile ottenere una frase casuale all'indirizzo `workstation:8080/sentence`.

In pratica, l'applicazione può essere verificata usando lo script `run-curl-client-forever.sh` (alla fine va arrestato con **CTRL-C**). 

## Arresto 

Per arrestare l'applicazione, eseguire lo script `stop-sentence-stack.sh` 

