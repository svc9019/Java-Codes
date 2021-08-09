#!/bin/bash
read value

case $value in
  1) echo "Your grade is E" ;;
  2) echo "Your grade is D" ;;
  3) echo "Your grade is C" ;;
  4) echo "Your grade is B" ;;
  5) echo "Your grade is A" ;;
  *) echo "Please enter a valid score" ;;
esac
break
