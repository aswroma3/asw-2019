# Developer 

Questo è un ambiente di esecuzione pensato per la compilazione dei progetti, 
nonché per l'esecuzione di applicazioni Java non distribuite.  
E' composto da una sola macchina virtuale **dev** (*developer*). 

## Descrizione delle macchine virtuali 

### dev

La macchina virtuale **dev** ha il seguente software 

* Ubuntu 18.04 LTS a 64 bit (by Bento) 

* Oracle Java SDK 
  
* Gradle 

* Maven 

Configurazione di rete 

* Indirizzo IP: 10.11.1.111 

* Porte pubblicate sull'host: 8080 -> 8080 (http), 9092 -> 9092 (Kafka), 5432 -> 5432 (Postgres)

Hardware (virtuale) 

* Memoria: 2048 MB (2 GB) 

* Virtual CPU: 2

 
