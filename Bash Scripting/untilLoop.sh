#!/bin/bash
a=1
read n
until [[ a -eq $((n+1)) ]]; do
  #statements
  echo $a
  ((a++))
done
