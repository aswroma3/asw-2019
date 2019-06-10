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





Complessivamente, l'applicazione *sentence* espone un servizio REST sulla porta **8080** del nodo **workstation**, 
ed è possibile ottenere una frase casuale all'indirizzo `localhost:8080/sentence`.

In pratica, l'applicazione può essere verificata usando lo script `run-curl-client.sh` oppure `run-curl-client-forever.sh` (alla fine va arrestato con **CTRL-C**). 

In modo analogo, l'applicazione *hello*
Alla fine, l'applicazione può essere arrestata usando lo script `stop-java-processes.sh` (**da usare con cautela!**). 

**Attenzione**: lo script `stop-java-processes.sh` fa il `kill -9` di tutti i processi Java in esecuzione. 




Gli esempi sono relativi a due applicazioni principali: 

* l'applicazione **sentence**, mostrata in più versioni   

* una semplice applicazione web **hello**  

Inoltre, a titolo di esempio, il sottoprogetto **b-registry-service** 
mostra gli script per avviare un *registry privato* in uno swarm. 
(Non necessario, perché nell'ambiente [docker-swarm](../../environments/docker-swarm/) 
viene creato un registry privato al momento della preparazione dell'ambiente.)


### Applicazione **sentence**

L'applicazione **sentence** è formata da più servizi, e realizzata in più versioni: 
  
* **a-sentence-compose** va eseguita in un nodo Docker ([docker](../../environments/docker/)), con *Docker* oppure con *Docker Compose* 

* **d-sentence-swarm-eureka-zuul** va eseguita in un cluster Docker ([docker-swarm](../../environments/docker-swarm/)), come *stack Docker* 

* anche **e-sentence-swarm-zuul** va eseguita in un cluster Docker ([docker-swarm](../../environments/docker-swarm/)), come *stack Docker* 


### Servizio **hello-service**

L'applicazione **c-hello-service**, è invece formata da un singolo servizio. 
Si tratta di una semplice applicazione REST, che restituisce un saluto  
che include il nome del nodo in cui viene eseguito il servizio. 
Dopo essere stata compilata, va eseguita come *servizio Docker*, con più repliche, 
in un cluster Docker ([docker-swarm](../../environments/docker-swarm/)). 


### Ambiente di esecuzione 

Queste applicazioni vanno eseguite negli ambienti 
[docker](../../environments/docker/) 
oppure [docker-swarm](../../environments/docker-swarm/). 

