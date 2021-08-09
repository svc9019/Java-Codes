#!/bin/#!/usr/bin/env bash

read number

if [ $number == 0 ]
then
  echo "number entered is zero"
elif [ $((number%2)) == 0 ]
then
  echo "number entered is even"
elif [ $((number%2)) -ne 0 ]
then
  echo "number entered is odd"
else
  echo "Not a valid digit"
fi
