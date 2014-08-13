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

buildDestination=$streamDestination/$productVersion.$productQualifier
echo "stream destination: $streamDestination "
echo "build destination: $buildDestination "


# copying products

productsDir=$WORKSPACE/repository/full/target/products
productsDestination=$buildDestination/ide

mkdir -p $productsDestination
cp $productsDir/org.eclipse.rcptt.platform.product-linux.gtk.x86.zip $productsDestination/rcptt.ide-1.5.1-$typeAbbr$productQualifier-linux.gtk.x86.zip
cp $productsDir/org.eclipse.rcptt.platform.product-linux.gtk.x86_64.zip $productsDestination/rcptt.ide-1.5.1-$typeAbbr$productQualifier-linux.gtk.x86_64.zip
cp $productsDir/org.eclipse.rcptt.platform.product-macosx.cocoa.x86_64.zip $productsDestination/rcptt.ide-1.5.1-$typeAbbr$productQualifier-macosx.cocoa.x86_64.zip
cp $productsDir/org.eclipse.rcptt.platform.product-win32.win32.x86.zip $productsDestination/rcptt.ide-1.5.1-$typeAbbr$productQualifier-win32.win32.x86.zip
cp $productsDir/org.eclipse.rcptt.platform.product-win32.win32.x86_64.zip $productsDestination/rcptt.ide-1.5.1-$typeAbbr$productQualifier-win32.win32.x86_64.zip

# copy full repository
cp -r $WORKSPACE/repository/full/target/repository $buildDestination


# copy runtimes
cp -r $WORKSPACE/runtime/updates/org.eclipse.rcptt.updates.runtime/q7 $buildDestination/runtime3x
cp -r $WORKSPACE/runtime/updates/org.eclipse.rcptt.updates.runtime.e4x/q7 $buildDestination/runtime4x


# echo results

find $buildDestination

# discard old builds


#  symlink latest
