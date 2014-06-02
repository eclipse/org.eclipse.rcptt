#!/bin/bash
mvn clean install -Dajdt_repo=http://download.eclipse.org/tools/ajdt/37/update -Declipse_repo=http://download.eclipse.org/releases/indigo/
rm -rf ../com.xored.q7.updates.aspectj.e3x/dependencies
mkdir ../com.xored.q7.updates.aspectj.e3x/dependencies
cp -r ./repository/target/repository/ ../com.xored.q7.updates.aspectj.e3x/dependencies