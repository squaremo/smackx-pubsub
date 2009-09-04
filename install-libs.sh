#!/bin/sh
mvn install:install-file -DgroupId=jivesoftware -DartifactId=smack -Dversion=3.1.0-pubsub1 -Dpackaging=jar -Dfile=smack.jar
mvn install:install-file -DgroupId=jivesoftware -DartifactId=smackx -Dversion=3.1.0 -Dpackaging=jar -Dfile=smackx.jar
mvn install:install-file -DgroupId=jivesoftware -DartifactId=smack-test -Dversion=3.1.0 -Dpackaging=jar -Dfile=smack-test.jar
mvn install:install-file -DgroupId=jivesoftware -DartifactId=smack-debug -Dversion=3.1.0 -Dpackaging=jar -Dfile=smackx-debug.jar
