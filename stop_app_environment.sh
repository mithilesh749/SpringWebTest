#!/bin/bash

if [ ! -z "$1" ]
  then
    echo "Stopping app: $1"
    docker stop $1
    docker rm $1
  else
    echo "Argument 'AppName' missing"
fi