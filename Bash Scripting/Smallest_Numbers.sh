#!/bin/bash

read num1
read num2
read num3

if [ $num1 -lt $num2 ]
then
  if [ $num1 -lt $num3 ]
  then
    echo "The smallest number entered is $num1"
  else
    echo "The smallest number entered is $num3"
  fi
else
  if [ $num2 -lt $num3 ]
  then
    echo "The smallest number entered is $num2"
  else
    echo "The smallest number entered is $num3"
  fi
fi
