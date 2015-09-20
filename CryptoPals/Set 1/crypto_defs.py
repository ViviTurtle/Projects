#!/usr/bin/env python

## Author: Vivi Langga

#Taken from crytopals

import collections
import base64
import binascii

#Converts a hexadecimal string to base64
#@param hexa the hex string to encode
#returns the base64 encoded string
def hex2b64(hexa):
	print "Converting " + hexa + "(hex) to base64"
	try:
		#decodes into hex than converts to base64
		temp = hexa.decode("hex")
		return base64.b64encode(temp)
	except Exception, e:
		print "Please enter a hex parameter" + str(e)

#xors two hexadecimal strings and xors them together
#note this takes into account a repeating key xor, or a single key
#@param base the larger hex string to xor
#@param x he smaller hex string to xor
#returns the result as hexadecimal (no "0x")
def xor(base, x):
	base2 = x
	while len(base) != len(base2):
		base2 = base2 + x
		if len(base2) > len(base):
	
			base2 = base2[0:len(base)]
	answer = hex(int(base,16) ^ int(base2,16))
	return answer[2:len(answer) -1 ]

#Given an ascii strings, analyzes the charcter frequency to see if 
#it matches the most common letters in the english alphabet
#@param ascii_string the string to analyze
#returns the score which represents how well it matches the character frequency
def char_freq_analyze(ascii_string):
	#http://www.math.cornell.edu/~mec/2003-2004/cryptography/subs/frequencies.html
	#percentage freqeuencies of the english alphabet
	characterFrequency = {
		" " : 0.1874,
		'e' : 0.096,
		'e' : 0.096,
		't' : 0.0702,
		'a' : 0.0621,
		'o' : 0.0584,
		'i' : 0.0522,
		'n' : 0.0521,
		'h' : 0.0487,
		's' : 0.0477,
		'r' : 0.0443,
		'd' : 0.0352,
		'l' : 0.0320,
		'u' : 0.0225,
		'm' : 0.0194,
		'c' : 0.0188,
		'w' : 0.0182,
		'g' : 0.0166,
		'f' : 0.0162,
		'y' : 0.0156,
		'p' : 0.0131,
		',' : 0.0124,
		'.' : 0.0121,
		'b' : 0.0119,
		'k' : 0.0074,
		'v' : 0.0071,
		'\"' : 0.0067,
		"\'" : 0.0044,
		'-' : 0.0026,
		'?' : 0.0012,
		'x' : 0.0012,
		'j' : 0.0012,
		';' : 0.0008,
		'!' : 0.0008,
		'q' : 0.0007,
		'z' : 0.0007,
		':' : 0.0003,
		'1' : 0.0002,
		'-' : 0.0001,
		'0' : 0.0001,
		')' : 0.0001,
		'*' : 0.0001,
		'(' : 0.0001,
		'2' : 0.0001,
		"`" : 0.0001,
		'3' : 0.0001,
		'9' : 0.0001,
		'5' : 0.0001,
		'4' : 0.0001,
		'8' : 0.0000,
		'7' : 0.0000,
		'6' : 0.0000,
		'/' : 0.0000,
		'_' : 0.0000,
		'[' : 0.0000,
		']' : 0.0000,
		'=' : 0.0000,
		'>' : 0.0000,
		'<' : 0.0000,
		'~' : 0.0000,
		'#' : 0.0000,
		'&' : 0.0000,
		'{' : 0.0000,
		'}' : 0.0000,
		'*' : 0.0000,
		'^' : 0.0000,
		'|' : 0.0000,
		'\\' : 0.0000,
		'@' : 0.0000,
		'%' : 0.0000,
		'$' : 0.0000,
		'+' : 0.0000,

	}
	#counts every character in the string
	count = collections.Counter(list(ascii_string))
	score = 0.0
	for i in count:
		if i in characterFrequency:
			#takes the actual frequency (mean) the letter appeared in the string and subtracts it from the expected percentages
			#The lower the score is the better it matches
			score += abs((float(count[i])/float(len(ascii_string)))-characterFrequency[i])
		else:
			score += 1
	return score
		
#Solves single character xor
#@param hexa the hexadecimal string to solve
#returns answer+applesarewesome+score 
def single_char_xor_solver(hexa):
	lowest = 10000
	actual_answer = ""
	#Range of ascii characters
	for x in range(0,256):
		#xors string to all ascii characters
		answer = xor(hexa, chr(x).encode("hex"))
		#adds leading zeros for hex
		if len(answer) % 2 == 1:
			answer += "0"
		#Replaces NULL bytes to a space
		answer = answer.decode("hex").lower().replace('\x00', " ")
		#Gets score of string
		score = char_freq_analyze(answer)
		#Saves the lowest score
		if lowest > score:
			lowest = score
			actual_answer = answer
	#make sure to .split("applesareawesome")
	return actual_answer+'applesareawesome'+str(lowest)

#Finds the hamming weights between two equal length hex values
#@param hex1 the first hex value
#@param hex2 the second hex valuue
#returns te hamming weight
def find_hamming_weight(hex1, hex2):
	temp = hex(long(hex1,16) ^ long(hex2,16))[2:]
	return bin(long(temp,16))[2:].count("1")
	

#if __name__ == '__main__':
