#!/usr/bin/python 

inputfile = open("input.txt", "r"); 
line = inputfile.readline(); 
tests = line.split("),"); 
for test in tests: 
	if test[:3] == "get": 
		print "cout << cache." + test + ") << endl;"; 
	else: 
		print "cache." + test + ");"; 
inputfile.close(); 
