#! /bin/bash

WORKSPACE=${WORKSPACE:-$PWD}
# qualifier and version
source $WORKSPACE/repository/full/target/publisher.properties

echo "productVersion: $productVersion"
echo "productQualifier: $productQualifier"


downloadsHome=/home/data/httpd/download.eclipse.org/rcptt
type=nightly
typeAbbr=N

# where all downloads of this branch reside
streamDestination=$downloadsHome/$type/$productVersion

buildDestination=$streamDestination/$productQualifier
echo "stream destination: $streamDestination "
echo "build destination: $buildDestination "


# copying products

productsDir=$WORKSPACE/repository/full/target/products
productsDestination=$buildDestination/ide

mkdir -p $productsDestination
cp $productsDir/org.eclipse.rcptt.platform.product-linux.gtk.x86.zip       $productsDestination/rcptt.ide-incubation-$productVersion-$typeAbbr$productQualifier-linux.gtk.x86.zip
cp $productsDir/org.eclipse.rcptt.platform.product-linux.gtk.x86_64.zip    $productsDestination/rcptt.ide-incubation-$productVersion-$typeAbbr$productQualifier-linux.gtk.x86_64.zip
cp $productsDir/org.eclipse.rcptt.platform.product-macosx.cocoa.x86_64.zip $productsDestination/rcptt.ide-incubation-$productVersion-$typeAbbr$productQualifier-macosx.cocoa.x86_64.zip
cp $productsDir/org.eclipse.rcptt.platform.product-win32.win32.x86.zip     $productsDestination/rcptt.ide-incubation-$productVersion-$typeAbbr$productQualifier-win32.win32.x86.zip
cp $productsDir/org.eclipse.rcptt.platform.product-win32.win32.x86_64.zip  $productsDestination/rcptt.ide-incubation-$productVersion-$typeAbbr$productQualifier-win32.win32.x86_64.zip

# copy full repository
cp -r $WORKSPACE/repository/full/target/repository $buildDestination

# copy full repository archive
cp -r $WORKSPACE/repository/full/target/full-$productVersion-SNAPSHOT.zip $buildDestination/repository-incubation-$productVersion-$typeAbbr$productQualifier.zip

# copy runtimes
cp -r $WORKSPACE/runtime/updates/org.eclipse.rcptt.updates.runtime/q7 $buildDestination/runtime3x
cp -r $WORKSPACE/runtime/updates/org.eclipse.rcptt.updates.runtime.e4x/q7 $buildDestination/runtime4x


# discard old builds
buildsToKeep=5
let "tailArg=$buildsToKeep+1"

ls -r $streamDestination | grep -v latest | tail -n +$tailArg | xargs -I {} rm -r $streamDestination/{}

# symlink latest

latest=$streamDestination/latest
if [ -d "$latest" ]; then
    rm -r $latest
fi
mkdir -p $latest

cp -r $buildDestination/repository $latest/repository
cp -r $buildDestination/repository-incubation-$productVersion-$typeAbbr$productQualifier.zip $latest/repository-incubation-$type.zip
cp -r $buildDestination/runtime3x $latest/runtime3x
cp -r $buildDestination/runtime4x $latest/runtime4x

mkdir $latest/ide

cp $productsDestination/rcptt.ide-incubation-$productVersion-$typeAbbr$productQualifier-linux.gtk.x86.zip       $latest/ide/rcptt.ide-incubation-$productVersion-$type-linux.gtk.x86.zip
cp $productsDestination/rcptt.ide-incubation-$productVersion-$typeAbbr$productQualifier-linux.gtk.x86_64.zip    $latest/ide/rcptt.ide-incubation-$productVersion-$type-linux.gtk.x86_64.zip
cp $productsDestination/rcptt.ide-incubation-$productVersion-$typeAbbr$productQualifier-macosx.cocoa.x86_64.zip $latest/ide/rcptt.ide-incubation-$productVersion-$type-macosx.cocoa.x86_64.zip
cp $productsDestination/rcptt.ide-incubation-$productVersion-$typeAbbr$productQualifier-win32.win32.x86.zip     $latest/ide/rcptt.ide-incubation-$productVersion-$type-win32.win32.x86.zip
cp $productsDestination/rcptt.ide-incubation-$productVersion-$typeAbbr$productQualifier-win32.win32.x86_64.zip  $latest/ide/rcptt.ide-incubation-$productVersion-$type-win32.win32.x86_64.zip


DOC_DIR=$WORKSPACE/releng/doc/target
if [ -d "$DOC_DIR" ]; then
    cp -r $DOC_DIR/doc $buildDestination
    cp -r $DOC_DIR/doc $latest
fi
