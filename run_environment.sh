#!/bin/bash

if [ -z "$1" ]
  then
    echo "environment argument not supplied"
fi
if [ -z "$2" ]
  then
    echo "App name argument not supplied"
fi
if [ -z "$3" ]
  then
    echo "Port argument not supplied"
fi

echo "First arg: $1"
echo "Second arg: $2"
echo "Third arg: $3"

if [ ! -z "$2" ] && [ ! -z "$2" ] && [ ! -z "$3" ]
  then
    docker run -d -p $3:8080 -e "SPRING_PROFILES_ACTIVE=$1" --name $2 spring-web-test:latest
  else
    echo "invalid Args"
fi