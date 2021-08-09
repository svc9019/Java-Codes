#!/bin/bash

read age
read vote

if [ $age -ge 18 ]
then
  if [ $vote -eq 1 ]
  then
    echo "You have voted for Ram"
  elif [ $vote -eq 2 ]
  then
    echo "You have voted for Shyam"
  else
    echo "You have voted for Ghanshyam"
  fi
else
  echo "You are not eligible"
fi

while [ $age -ge 18 ]; do
  #statements
  case $vote in
    1) echo "You have voted for Ram" ;;
    2) echo "You have voted for Shyam" ;;
    3) echo "You have voted for Ghanshyam" ;;
    *) echo "You are not eligible"
  esac
done
