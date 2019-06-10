# Sentence (con Eureka, Feign e Hystrix)

Questo sottoprogetto mostra una versione dell'applicazione **sentence** che utilizza un servizio di service discovery (*Eureka*), client REST generati automaticamente (con *Feign*) e Circuit Breaker (*Hystrix*). 

I servizi *word-service* e *sentence-service* agiscono da client nei confronti di Eureka. 

Il servizio *sentence-service* usa Feign e Hystrix per accedere alle diverse istanze del servizio *word-service*. 

## Componenti eseguibili

Questa versione dell'applicazione **sentence** è formata dai seguenti componenti eseguibili: 

* **eureka-server** è un servizio di service discovery (Eureka), sulla porta *8761*
* **word-service** è il servizio per la generazione di parole casuali, che agisce da client nei confronti di Eureka, e che viene avviato con tre istanze: 
  * una con il profilo *subject* su una porta casuale, 
  * una con il profilo *verb* su una porta casuale, 
  * una con il profilo *object* su una porta casuale, 
* **sentence-service** è il servizio per la generazione delle frasi casuali, sulla porta *8080*, che agisce da client nei confronti dei servizi per le parole tramite Eureka, Feign e Hystrix 

## Esecuzione 

Per eseguire questa versione dell'applicazione: 

* per avviare l'applicazione *sentence* (compreso Eureka), eseguire lo script `run-sentence-ews.sh` 

## Esperimenti 

### Esecuzione con più istanze dei servizi per le parole 

Lo script `run-sentence-ews-replicated.sh` avvia due istanze del servizio *word-service* per ciascuno dei suoi tre profili. 

