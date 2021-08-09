#!/bin/bash

sum=0
i="y"

read num1
read num2

while [ $i = "y" ]; do
  echo "1.Addition"
  echo "2.Substraction"
  echo "3.Muliply"
  echo "4.Division"
  echo "Enter the Choice"
  read ch
  case $ch in
    1)
      sum=$(expr $num1 + $num2 )
      echo "Sum=$sum"
      ;;
    2)
      sum=$(expr $num1 - $num2)
      echo "Sum=$sum"
      ;;
    3)
      sum=$(expr $num1 \* $num2)
      echo "Sum=$sum"
      ;;
    4)
      sum=$(expr $num1 / $num2)
      echo "Sum=$sum"
      ;;
    *) echo "Invalid Choice" ;;
  esac
  break
done
