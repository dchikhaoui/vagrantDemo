# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|
    config.vm.box = "hashicorp/bionic64"
    config.vm.provision :shell, path: "bootstrap.sh"
    config.vm.network "forwarded_port", guest: 8080, host: 9090, host_ip: "127.0.0.1"
end