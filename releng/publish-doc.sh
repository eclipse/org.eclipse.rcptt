#! /bin/bash

WORKSPACE=${WORKSPACE:-$PWD}
QUALIFIER=${QUALIFIER:-linux/gtk/x86_64}
DOWNLOADS_HOME=${DOWNLOADS_HOME:-/home/data/httpd/download.eclipse.org/rcptt}
echo "WORKSPACE = $WORKSPACE"
echo "QUALIFIER = $QUALIFIER"
echo "DOWNLOADS_HOME = $DOWNLOADS_HOME"
# qualifier and version
source $WORKSPACE/repository/full/target/publisher.properties

echo "productVersion = $productVersion"
echo "productQualifier = $productQualifier"


type=nightly
typeAbbr=N

# where all downloads of this branch reside
streamDestination=$DOWNLOADS_HOME/$type/$productVersion
buildDestination=$streamDestination/$productQualifier

echo "stream destination: $streamDestination "
echo "build destination: $buildDestination "

mkdir -p $buildDestination

productsDir=$WORKSPACE/repository/full/target/products


$productsDir/org.eclipse.rcptt.platform.product/$QUALIFIER/rcptt/rcptt \
    -application org.eclipse.rcptt.ecl.doc.generator \
    -output $buildDestination/ecl.html
