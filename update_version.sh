#!/bin/sh
#*******************************************************************************
# Copyright (c) 2009, 2019 Xored Software Inc and others.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
# 	Xored Software Inc - initial API and implementation and/or initial documentation
#*******************************************************************************
export MAVEN_OPTS="-Xms512m -Xmx1024m -XX:MaxMetaspaceSize=256m -XX:MaxPermSize=256m"

VERSION="$1"
if [ ! $VERSION ]; then
    echo "Version is not specified. Please, specify version number in x.y.z format."
    exit 900
fi

GOAL="org.eclipse.tycho:tycho-versions-plugin:set-version"
OPTIONS="-Dtycho.mode=maven -Dtycho.localArtifacts=ignore -DnewVersion=${VERSION}-SNAPSHOT -DupdateVersionRangeMatchingBounds"

echo "================= Updating All Components ================="
mvn $GOAL -f releng/pom.xml -P update-version $OPTIONS || exit 100

echo "================== Updating Maven Plugin =================="
mvn $GOAL -f maven-plugin/pom.xml $OPTIONS || exit 101

echo "================== Updating Maven Script =================="
mvn versions:set -f clean-pom.xml -DnewVersion=$VERSION-SNAPSHOT -DgenerateBackupPoms=false || exit 106

echo "==========================================================="
echo "This script updates version for most of plugins, but not\nfor all. So, after execution, it is needed to search\nthe old version number in the project directory and update\nversions in some places by hand."
echo "==========================================================="
