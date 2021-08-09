#!/bin/bash

read length
read breadth

if [ $length -eq $breadth ]
then
  echo "The quadrilateral is a square"
else
  echo "The quadrilateral is a rectangle"
fi
