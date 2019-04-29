# asw-880-strumenti-ambienti-virtuali

Questo "progetto" contiene la definizione di tre diversi *ambienti virtuali*, 
tutti basati sull'uso di *strumenti per la gestione di ambienti virtuali* 
come **Vagrant** e **Oracle VM VirtualBox**. 
Ciascuno di questi ambienti è composto da una singola macchina virtuale con *Apache HTTP Server*. 
Nei diversi ambienti, il provisioning della macchina virtuale viene effettuato in tre modi differenti. 


## Descrizione degli ambienti  


### a-apache-shell 

Nell'ambiente [a-apache-shell](a-apache-shell/)
il provisioning della macchina virtuale viene effettuato mediante l'uso di uno *script bash*. 

La macchina virtuale **precise64** ha il seguente software: 

* Ubuntu 12.04 LTS a 64 bit (Precise64) 

* Apache HTTP Server - installato mediante uno *script bash* 

Configurazione di rete 

* Indirizzo IP: 10.11.1.191 

* Porte pubblicate sull'host: 80 -> 8081 
  
  
### b-apache-puppet 

Nell'ambiente [b-apache-puppet](b-apache-puppet/)
il provisioning della macchina virtuale viene effettuato mediante l'uso di *Puppet Apply*. 

La macchina virtuale **precise64** ha il seguente software: 

* Ubuntu 12.04 LTS a 64 bit (Precise64) 

* Apache HTTP Server - installato mediante *Puppet Apply* 

Configurazione di rete 

* Indirizzo IP: 10.11.1.192 

* Porte pubblicate sull'host: 80 -> 8082 
  
  
### c-apache-puppetlabs-apache 

Nell'ambiente [c-apache-puppetlabs-apache](c-apache-puppetlabs-apache/)
il provisioning della macchina virtuale viene effettuato mediante l'uso di *Puppet Apply*, 
sulla base del modulo predefinito *puppetlabs/apache*. 

La macchina virtuale **precise64** ha il seguente software: 

* Ubuntu 12.04 LTS a 64 bit (Precise64) 

* Apache HTTP Server - installato mediante *Puppet Apply*, usando il modulo *puppetlabs/apache*

Configurazione di rete 

* Indirizzo IP: 10.11.1.193 

* Porte pubblicate sull'host: 80 -> 8083 
  


