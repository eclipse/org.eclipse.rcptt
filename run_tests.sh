#!/bin/bash
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
. repository/full/target/publisher.properties
mvn clean verify -B -f rcpttTests/pom.xml \
-DrcpttPath=`readlink -f repository/full/target/products/org.eclipse.rcptt.platform.product-linux.gtk.x86_64.zip` \
-DexplicitRunner=`readlink -f runner/product/target/rcptt.runner-*.zip` || true
test -f rcpttTests/target/results/tests.html
