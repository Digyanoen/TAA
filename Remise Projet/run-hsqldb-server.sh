#!/usr/bin/env bash
mvn dependency:copy-dependencies
mkdir data
cd data
java -cp ../hsqldb-2.3.4.jar org.hsqldb.Server
