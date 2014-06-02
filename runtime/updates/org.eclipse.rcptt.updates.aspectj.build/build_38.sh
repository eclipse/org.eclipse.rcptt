#!/bin/bash
mvn clean install -Dajdt_repo=http://download.eclipse.org/tools/ajdt/42/update -Declipse_repo=http://download.eclipse.org/releases/juno/
rm -rf ../com.xored.q7.updates.aspectj.e38x/dependencies
mkdir ../com.xored.q7.updates.aspectj.e38x/dependencies
cp -r ./repository/target/repository/ ../com.xored.q7.updates.aspectj.e38x/dependencies