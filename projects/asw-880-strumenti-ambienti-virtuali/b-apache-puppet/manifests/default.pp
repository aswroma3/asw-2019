node 'precise64' { 
  include apache
}

class apache { 
  package { 'apache2':
    ensure => present,
    require => Exec['apt-get update']
  }

  service { 'apache2':
    require => Package['apache2'],  
    ensure => running,
    enable => true, 
  }

  file { '/var/www': 
    require => Package['apache2'],  
    target => '/vagrant/www', 
    ensure => link,
    force => true 
  }
}

exec { 'apt-get update':
  command => '/usr/bin/apt-get update'
}

