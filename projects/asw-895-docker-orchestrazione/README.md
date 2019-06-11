# asw-895-docker-orchestrazione 

Questo progetto contiene alcune applicazioni che esemplificano 
il rilascio di applicazioni composte da uno o più servizi,  
da eseguire su un singolo nodo Docker oppure in un cluster (swarm) di nodi Docker. 

In particolare, le applicazioni sono in genere delle varianti dell'applicazione distribuita **sentence**, 
descritta nel progetto [asw-860-spring-cloud/](../asw-860-spring-cloud/). 

* [a-sentence-docker](a-sentence-docker/): per eseguire l'applicazione **sentence** usando solo *Docker*

* [b-sentence-compose](b-sentence-compose/): per eseguire l'applicazione **sentence** come composizione di contenitori, usando *Docker Compose*

* [c-hello-service](c-hello-service/): una semplice applicazione **hello**, eseguita come servizio in uno *swarm Docker* 

* [d-sentence-swarm](d-sentence-swarm/): per eseguire l'applicazione **sentence** come orchestrazione di contenitori, usando uno *swarm Docker*

Le diverse versioni di questa applicazione hanno una struttura simile (ma di volta in volta un po' diversa), e la loro costruzione ed esecuzione è descritta qui di seguito. 

## Build  

Per la costruzione di ciascuna versione dell'applicazione, bisogna 

1. posizionarsi nella cartella principale dell'applicazione di interesse - ad esempio `~/projects/asw-895-docker-orchestrazione/a-sentence-docker`

2. per compilare e assemblare l'applicazione, usare il comando `gradle assemble` oppure `gradle build` 

## Componenti eseguibili 

Le diverse versioni dell'applicazione sono in genere composte da più componenti eseguibili. 
Per la descrizione dei componenti eseguibili, vedere il file README nella cartella di ciascun sottoprogetto. 

### Ambiente di esecuzione 

Queste applicazioni vanno eseguite nell'ambiente [workstation](../../environments/workstation/), sul nodo **workstation**. 
Vanno però utilizzate più finestre (terminali) diverse. In genere, una per l'applicazione ed una per il suo client.  

### Esecuzione 

Per l'esecuzione delle diverse versioni dell'applicazione, vedere il file README nella cartella di ciascun sottoprogetto. 
