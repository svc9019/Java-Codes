#!/bin/bash

read studentName
read studentMarks

if [ $studentMarks -gt 100]
then
  echo "The grade of student named $studentName is A"
elif [ $studentMarks -gt 80 -a $studentMarks -le 100 ]
then
  echo "The grade of student named $studentName is B"
elif [ $studentMarks -gt 40 -a $studentMarks -le 80 ]
then
  echo "The grade of student named $studentName is C"
elif [ $studentMarks -le 40 ]
then
  echo "The grade of student named $studentName is D"
else
  echo "Enter Student Name and Marks"
fi
