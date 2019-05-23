# asw-860-spring-cloud

Questo progetto contiene alcune applicazioni che esemplificano l'uso di [Spring Cloud](https://spring.io/projects/spring-cloud) per la realizzazione di applicazioni *multi-servizi*. 

Gli esempi sono relativi ad un'applicazione distribuita **sentence**, il cui scopo è di generare delle semplici frasi casuali. 
L'applicazione viene mostrata in più versioni.  

* [a-sentence-basic](a-sentence-basic/): la versione di base  

* [b-sentence-config](b-sentence-config/): uso di un servizio di configurazione

* [c-sentence-config-bus](c-sentence-config-bus/): uso di un servizio di configurazione, con refresh dinamico delle configurazioni 

* [d-sentence-eureka-discovery](d-sentence-eureka-discovery/): uso di un servizio di discovery 

* [e-sentence-eureka-ribbon](e-sentence-eureka-ribbon/): uso di un load balancer lato client  

* [f-sentence-eureka-feign](f-sentence-eureka-feign/): uso di un client REST dichiarativo 

* [g-sentence-eureka-feign-hystrix](g-sentence-eureka-feign-hystrix/): uso di un circuit breaker 

* [h-sentence-eureka-feign-hystrix-zuul](h-sentence-eureka-feign-hystrix-zuul/): uso di un API gateway 

Le diverse versioni di questa applicazione hanno una struttura simile (ma di volta in volta un po' diversa), e la loro costruzione ed esecuzione è descritta qui di seguito. 

## Build  

Per la costruzione di ciascuna versione dell'applicazione, bisogna 

1. posizionarsi nella cartella principale dell'applicazione di interesse - ad esempio `~/projects/asw-860-spring-cloud/a-sentence-basic`

2. per compilare e assemblare l'applicazione, usare il comando `gradle assemble` oppure `gradle build` 

## Componenti eseguibili 

Ciascuna versione dell'applicazione è composta da due o più componenti eseguibili. 
Per la descrizione dei componenti eseguibili, vedere il file README nella cartella di ciascun sottoprogetto. 

### Ambiente di esecuzione 

Queste applicazioni vanno eseguite nell'ambiente [workstation](../../environments/workstation/), sul nodo **workstation**. 
Vanno però utilizzate più finestre (terminali) diverse. In genere, una per l'applicazione ed una per il suo client.  

### Esecuzione 

Per l'esecuzione delle diverse versioni dell'applicazione, vedere il file README nella cartella di ciascun sottoprogetto. 

In generale, per eseguire una versione dell'applicazione, bisogna avviare individualmente i servizi che la compongono. Ciascuna versione dell'applicazione contiene gli script necessari ad avviare l'applicazione. 

**Attenzione**: l'avvio dell'applicazione *sentence* può richiedere da qualche secondo a qualche minuto. 

Complessivamente, l'applicazione *sentence* espone un servizio REST sulla porta **8080** del nodo **workstation**, 
ed è possibile ottenere una frase casuale all'indirizzo `localhost:8080/sentence`.

In pratica, l'applicazione può essere verificata usando lo script `run-curl-client.sh` oppure `run-curl-client-forever.sh` (alla fine va arrestato con **CTRL-C**). 

Alla fine, l'applicazione può essere arrestata usando lo script `stop-java-processes.sh` (**da usare con cautela!**). 

**Attenzione**: lo script `stop-java-processes.sh` fa il `kill -9` di tutti i processi Java in esecuzione. 

