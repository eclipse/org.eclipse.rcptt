#! /bin/bash
set -x -e

: ${WORKSPACE:=$PWD}
: ${downloadsHome:=/home/data/httpd/download.eclipse.org/rcptt}
: ${type:=release}
: ${buildsToKeep:=5}

# qualifier and version
source $WORKSPACE/repository/full/target/publisher.properties
echo "productVersion: $productVersion"
echo "productQualifier: $productQualifier"
unqualifiedDecoration=$productVersion-$type

# where all downloads of this branch reside
test -d $downloadsHome/$type || exit 1 #folder for type should already exist

# qualifed copies of artifacts go here
buildDestination=$downloadsHome/$type/$productVersion
echo "build destination: $buildDestination "
rm -rf $buildDestination
mkdir $buildDestination #should fail if this directory already exists
mkdir $buildDestination/ide
mkdir $buildDestination/runner

# copying products
ideProductSourcePrefix=$WORKSPACE/repository/full/target/products/org.eclipse.rcptt.platform.product
for arch in linux.gtk.x86 linux.gtk.x86_64 macosx.cocoa.x86_64 win32.win32.x86 win32.win32.x86_64 ; do
	cp $ideProductSourcePrefix-$arch.zip $buildDestination/ide/rcptt.ide-$productVersion-$arch.zip
done

runnerProductSource=$WORKSPACE/runner/product/target/rcptt.runner-$productVersion.zip
cp  $runnerProductSource $buildDestination/runner/rcptt.runner-$productVersion.zip

# copy rcptt repository
repositorySource=$WORKSPACE/repository/rcptt/target/repository
cp -r $repositorySource $buildDestination

# copy rcptt repository archive
repositoryArchiveSource=$WORKSPACE/repository/rcptt/target/rcptt.repository-$productVersion-SNAPSHOT.zip
cp $repositoryArchiveSource $buildDestination/repository-$productVersion.zip

# copy runtimes
cp -r $WORKSPACE/runtime/updates/org.eclipse.rcptt.updates.runtime/q7 $buildDestination/runtime3x
cp -r $WORKSPACE/runtime/updates/org.eclipse.rcptt.updates.runtime.e4x/q7 $buildDestination/runtime4x

DOC_DIR=$WORKSPACE/releng/doc/target
if [ -d "$DOC_DIR" ]; then
    cp -r $DOC_DIR/doc $buildDestination
fi
