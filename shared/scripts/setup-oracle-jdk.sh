#!/bin/bash

# NON FUNZIONA PIU' IL DOWNLOAD DAL SITO ORACLE. 
# PER UTILIZZARE QUESTO SCRIPT, E' PRIMA NECESSARIO SCARICARE MANUALMENTE LA VERSIONE DI ORACLE JDK SPECIFICATA QUI SOTTO.

source "/home/asw/shared/scripts/common.sh"

# set up Java constants 
JAVA_VERSION=8
JAVA_MINOR_VERSION=211
JAVA_BUILD=12
JAVA_HEX=478a62b7d4e34b78b671c754eaaf38ab

# https://download.oracle.com/otn/java/jdk/8u211-b12/478a62b7d4e34b78b671c754eaaf38ab/jdk-8u211-linux-x64.tar.gz

JAVA_FILE_NAME=jdk-${JAVA_VERSION}u${JAVA_MINOR_VERSION}-linux-x64
JAVA_ARCHIVE=${JAVA_FILE_NAME}.tar.gz
GET_JAVA_URL=https://download.oracle.com/otn/java/jdk/${JAVA_VERSION}u${JAVA_MINOR_VERSION}-b${JAVA_BUILD}/${JAVA_HEX}
JAVA_JDK_PATH=/usr/local/jdk1.${JAVA_VERSION}.0_${JAVA_MINOR_VERSION} 
# e.g., /usr/local/jdk1.8.0_211
JAVA_JRE_PATH=/usr/lib/jvm/jre 

function installLocalJava {
	echo "====================="
	echo "installing oracle jdk"
	echo "====================="
	FILE=${ASW_DOWNLOADS}/$JAVA_ARCHIVE
	tar -xzf $FILE -C /usr/local
}

function installRemoteJava {
	echo "======================"
	echo "downloading oracle jdk"
	echo "======================"
	wget -nv -P ${ASW_DOWNLOADS} --no-check-certificate -c --header "Cookie: oraclelicense=accept-securebackup-cookie;" "${GET_JAVA_URL}/${JAVA_ARCHIVE}" 
#	wget -nv -P ${ASW_DOWNLOADS} --header "Cookie: oraclelicense=accept-securebackup-cookie;" "${GET_JAVA_URL}/${JAVA_ARCHIVE}" 
	installLocalJava 
}

function setupJava {
	echo "setting up java"
	if downloadExists $JAVA_ARCHIVE; then
		ln -s $JAVA_JDK_PATH /usr/local/java
	else
		ln -s $JAVA_JRE_PATH /usr/local/java
	fi
}

function setupEnvVars {
	echo "creating java environment variables"
	echo export JAVA_HOME=/usr/local/java >> /etc/profile.d/java.sh
	echo export PATH=\${JAVA_HOME}/bin:\${PATH} >> /etc/profile.d/java.sh
}

function installJava {
	if downloadExists $JAVA_ARCHIVE; then
		installLocalJava
	else
		installRemoteJava
	fi
}

echo "setup java"
installJava
setupJava
setupEnvVars
