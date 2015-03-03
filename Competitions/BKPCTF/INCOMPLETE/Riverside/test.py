#!/usr/bin/env python
#
# Haymarket 
# Reversing 150
# From Boston Key Party CTF 2015
#
#Monty Hall wrote a script of how he was supposed to run one of his game 
#shows for his trusty accounting computer some time ago, but hes not really 
#sure what the punch cards mean any more. I mean, that was a while ago. Only, 
#hes sure his key is hidden somewhere in these punch-cards, if he could figure 
#out how to run them...

#http://bostonkeyparty.net/haymarket.tar.gz.fe35f59bfa869a0555e9972efa3ddd2d 

#Author: Vivi Langga
import sys

filename = sys.argv[1]
txt = open(filename)
ssearch = 'D......S'
ssearch2 = 'D......C'
input1 = txt.read()
stringbuilder = ''
for x in range (0, len(input1)):
	if input1[x:x+8] == ssearch or input1[x:x+8] == ssearch2:
		if input1[x+82:x+86] != '....':
			#print input1[x+82:x+86]
			stringbuilder = stringbuilder + input1[x+82:x+86]
stringbuilder = stringbuilder.replace(".","");
stringbuilder = stringbuilder.replace("\n","");
print stringbuilder

#print "Type the file name again:"
#file_again = raw_input("> ")

#txt_again = open(file_again)

#print txt_again.read()
