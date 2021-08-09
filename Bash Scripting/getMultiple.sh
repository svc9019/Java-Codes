#!/bin/bash
count=0
a=1
read n
read x
until [ $n -le $a ]
do
  if [ $((n%x)) == 0 ]
  then
     count=$((count+1))
  fi
  ((n--))
done
echo $count
