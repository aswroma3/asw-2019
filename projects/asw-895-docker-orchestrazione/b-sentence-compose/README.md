# Sentence (con Docker Compose)

Questo sottoprogetto mostra come eseguire una versione dell'applicazione **sentence** usando *Docker Compose*. 

## Componenti eseguibili

Questa versione dell'applicazione **sentence** è formata dai seguenti componenti eseguibili: 

* **eureka-server** è un servizio di service discovery (Eureka)
* **word-service** è il servizio per la generazione di parole casuali, che agisce da client nei confronti di Eureka, e che viene avviato con tre istanze: 
  * una con il profilo *subject* su una porta casuale, 
  * una con il profilo *verb* su una porta casuale, 
  * una con il profilo *object* su una porta casuale, 
* **sentence-service** è il servizio per la generazione delle frasi casuali, su una porta casuale, che agisce da client nei confronti dei servizi per le parole tramite Eureka, Feign e Hystrix 
* **zuul-gateway** è un API gateway per esporre le funzionalità dell'intera applicazione sulla porta *8080* 

## Ambiente di esecuzione 

Questa applicazione può essere costruita ed eseguita nell'ambiente [workstation](../../environments/workstation/), sul nodo **workstation**. 
Vanno però utilizzate più finestre (terminali) diverse. In genere, una per l'applicazione ed una per il suo client.  

## Build (Java) 

Per la costruzione dell'applicazione, eseguire il comando `gradle assemble` oppure `gradle build`, oppure eseguire lo script `build-java-projects.sh`

## Build (Docker) 

Per la costruzione delle immagini Docker, eseguire lo script `build-docker-images-with-compose.sh` 

## Esecuzione 

Per eseguire l'applicazione, eseguire lo script `run-with-compose.sh` 

Complessivamente, l'applicazione *sentence* espone un servizio REST sulla porta **8080** del nodo **workstation**, 
ed è possibile ottenere una frase casuale all'indirizzo `localhost:8080/sentence`.

In pratica, l'applicazione può essere verificata usando lo script `run-curl-client.sh` oppure `run-curl-client-forever.sh` (alla fine va arrestato con **CTRL-C**). 

## Arresto 

Per arrestare l'applicazione, eseguire lo script `stop-with-compose.sh` 

