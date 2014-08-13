#! /bin/bash

WORKSPACE=${WORKSPACE:-$PWD}
# qualifier and version
source $WORKSPACE/repository/full/target/publisher.properties

echo "productVersion: $productVersion"
echo "productQualifier: $productQualifier"


downloadsHome=/home/data/httpd/download.eclipse.org/rcptt
type=nightly

# where all downloads of this branch reside
streamDestination=$downloadsHome/$type/$productVersion

buildDestination=$streamDestination/$productVersion.$productQualifier
echo "stream destination: $streamDestination "
echo "build destination: $buildDestination "
# discard old builds
