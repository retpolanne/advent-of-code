#!/bin/bash

cat /tmp/numbers | while read number_line; do
	number=`echo $number_line | awk '{print $1}'`
	symbol=`echo $number_line | awk '{print $2}'`
	echo $number $symbol

	sed -ibak "s/$number/$symbol/g" /tmp/input

	for line in `cat /tmp/input`; do 
		echo "----- $line"
		echo $line | ggrep -Po "\d" | head -1
		echo $line | ggrep -Po "\d" | tail -1
	done
done
