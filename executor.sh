#!/bin/bash

# Usage:
# ./executor.sh num_tries cmd
# Scala: ../executor.sh 5 "scala -J-Xmx2g Main"

for i in $(seq 1 $1);
do
    echo "----Executing test $i----"
    eval $2
    echo ''
    sleep 2
done