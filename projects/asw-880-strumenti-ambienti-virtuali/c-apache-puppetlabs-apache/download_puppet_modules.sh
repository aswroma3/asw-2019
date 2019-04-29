#!/bin/bash

PUPPET_MODULE_PATH=/vagrant/puppet/modules

puppet module install puppetlabs-stdlib --version 4.11.0 --force --modulepath ${PUPPET_MODULE_PATH}
puppet module install puppetlabs-concat --version 1.2.5 --force --modulepath ${PUPPET_MODULE_PATH}
puppet module install puppetlabs-apache --version 1.7.1 --force --modulepath ${PUPPET_MODULE_PATH}
