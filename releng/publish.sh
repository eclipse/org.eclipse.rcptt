#! /bin/bash
#*******************************************************************************
# Copyright (c) 2009, 2016 Xored Software Inc and others.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#  
# Contributors:
# 	Xored Software Inc - initial API and implementation and/or initial documentation
#*******************************************************************************
set -x -e

: ${WORKSPACE:=$PWD}
: ${downloadsHome:=/home/data/httpd/download.eclipse.org/rcptt}
: ${type:=nightly}
: ${typeAbbr:=N}
: ${buildsToKeep:=5}

# qualifier and version
source $WORKSPACE/repository/full/target/publisher.properties
echo "productVersion: $productVersion"
echo "productQualifier: $productQualifier"
qualifiedDecoration=$productVersion-$typeAbbr$productQualifier
unqualifiedDecoration=$productVersion-$type

# where all downloads of this branch reside
test -d $downloadsHome/$type || exit 1 #folder for type should already exist
mkdir -p $downloadsHome/$type/$productVersion 
streamDestination=$downloadsHome/$type/$productVersion

# qualifed copies of artifacts go here
buildDestination=$streamDestination/$productQualifier
echo "stream destination: $streamDestination "
echo "build destination: $buildDestination "
mkdir $buildDestination #should fail if this directory already exists
mkdir $buildDestination/ide
mkdir $buildDestination/runner

# latest folder
# contains artifacts with unqualified names 
latest=$streamDestination/latest
if [ -d "$latest" ]; then
    rm -r $latest
fi

mkdir $latest
mkdir $latest/ide
mkdir $latest/runner
mkdir $latest/full

# copying products
ideProductSourcePrefix=$WORKSPACE/repository/full/target/products/org.eclipse.rcptt.platform.product
for arch in linux.gtk.x86 linux.gtk.x86_64 macosx.cocoa.x86_64 win32.win32.x86 win32.win32.x86_64 ; do
	cp $ideProductSourcePrefix-$arch.zip $buildDestination/ide/rcptt.ide-$qualifiedDecoration-$arch.zip
	cp $ideProductSourcePrefix-$arch.zip $latest/ide/rcptt.ide-$unqualifiedDecoration-$arch.zip
done

runnerProductSource=$WORKSPACE/runner/product/target/rcptt.runner-$productVersion-SNAPSHOT.zip
cp  $runnerProductSource $buildDestination/runner/rcptt.runner-$qualifiedDecoration.zip
cp  $runnerProductSource $latest/runner/rcptt.runner-$unqualifiedDecoration.zip

# copy rcptt repository
repositorySource=$WORKSPACE/repository/rcptt/target/repository
cp -r $repositorySource $buildDestination
cp -r $repositorySource $latest

# copy full repository
repositorySource=$WORKSPACE/repository/full/target/repository
cp -r $repositorySource $buildDestination/full/
cp -r $repositorySource $latest/full

# copy rcptt repository archive
repositoryArchiveSource=$WORKSPACE/repository/rcptt/target/rcptt.repository-$productVersion-SNAPSHOT.zip
cp $repositoryArchiveSource $buildDestination/repository-$qualifiedDecoration.zip
cp $repositoryArchiveSource $latest/repository-$unqualifiedDecoration.zip

# copy runtimes
cp -r $WORKSPACE/runtime/updates/org.eclipse.rcptt.updates.runtime/q7 $buildDestination/runtime3x
cp -r $WORKSPACE/runtime/updates/org.eclipse.rcptt.updates.runtime.e4x/q7 $buildDestination/runtime4x
cp -r $buildDestination/runtime3x $latest/runtime3x
cp -r $buildDestination/runtime4x $latest/runtime4x

DOC_DIR=$WORKSPACE/releng/doc/target
if [ -d "$DOC_DIR" ]; then
    cp -r $DOC_DIR/doc $buildDestination
    cp -r $DOC_DIR/doc $latest
fi

# discard old builds
let "tailArg=$buildsToKeep+1"
for old in `ls -r $streamDestination | grep -v latest | tail -n +$tailArg` ; do
	rm -r $streamDestination/$old
done
