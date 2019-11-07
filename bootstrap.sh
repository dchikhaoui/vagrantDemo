#!/usr/bin/env bash

# install dependencies
echo "[+] cleaning and updating apt-get"
apt-get clean -qq
apt-get update -qq
echo "[+] installing dependencies"
apt-get install -y unzip maven -qq
echo "[+] installing JDK"
apt-get install -y default-jdk -qq
# set env variables
export JAVA_HOME=$(update-java-alternatives -l | awk '{print $3}')

# setup Tomcat
echo "[+] setting up Tomcat"
mkdir /opt/tomcat
unzip -q -d /opt/tomcat /vagrant/lib/apache-tomcat.zip
chmod -R +x /opt/tomcat/apache-tomcat/bin

# crate the application
mvn -f /vagrant/app/pom.xml package # package with maven
cp /vagrant/app/target/SecureApplication.war /opt/tomcat/apache-tomcat/webapps/SecureApplication.war # copy into applications directory

# start Tomcat
echo "[+] starting Tomcat"
/opt/tomcat/apache-tomcat/bin/startup.sh

echo "[!] done"
