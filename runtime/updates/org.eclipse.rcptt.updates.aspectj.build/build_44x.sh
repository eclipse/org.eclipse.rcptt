#!/bin/bash
mvn clean install -Dajdt_repo=http://download.xored.com/mirrors/ajdt_44/ -Declipse_repo=http://download.eclipse.org/eclipse/updates/4.4milestones
rm -rf ../com.xored.q7.updates.aspectj.e44x/dependencies
mkdir ../com.xored.q7.updates.aspectj.e44x/dependencies
cp -r ./repository/target/repository/ ../com.xored.q7.updates.aspectj.e44x/dependencies