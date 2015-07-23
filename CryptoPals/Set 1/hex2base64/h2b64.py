#!/usr/bin/env python

## Author: Vivi Langga

#Taken from crytopals


import re
import sys
import base64
import collections

error = "Please try again"

def hex2b64(hexa):
	try:
		temp = hexa.decode("hex")
		return base64.b64encode(temp)
	except Exception, e:
		print "Please enter a hex parameter"

def xor(hex1, hex2):
	answer = hex(int(hex1,16) ^ int(hex2,16))
	return answer[2:len(answer) -1 ]

def has_alphanumeric_or_punctuation(text):
	for i in text:
			if ord(i) < 32 or ord(i) > 126:
				return False
	return True

def char_freq_decoder(hexa):
	#http://www.math.cornell.edu/~mec/2003-2004/cryptography/subs/frequencies.html
	characterFrequency = {
		" " : 0.1874,
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
	lowest = 10000
	actual_answer = ""
	for x in range(0,256):
		skip = 0
		answer = ""
		hex2 = len(hexa)/2 * chr(x).encode("hex")
		answer = xor(hexa, hex2)
		if len(answer) % 2 == 1:
			answer += "0"
		answer = answer.decode("hex").lower()
		#print "\nAnswer: "+ answer
		#if has_alphanumeric_or_punctuation(answer):
		count = collections.Counter(list(answer))
		score = 0.0
		for i in count:
			if i in characterFrequency:
				score += abs(float(count[i])/float(len(answer))-characterFrequency[i])
			else:
				score += 1
		#print "Answer: "+  answer
		#print "Total: "  + str(score)
		if lowest > score:
			lowest = score
			actual_answer = answer
	#	#print "Total: "  + str(lowest)
	#else:
	#	print "Skipping"
	#if lowest != 10000:
	#	print lowest
	return actual_answer



# Convert hex to base64
#http://cryptopals.com/sets/1/challenges/1/
#Hex: 49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d
#b64: SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t
def problem1():
	test = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d"
	expected_answer = "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t"
	print "Converting " + test + "(Hex) to Base64"
	print "Expecting: " + expected_answer
	actual_answer = hex2b64(test)

	print "Recieved: " + actual_answer

	if hex2b64(test) == actual_answer:
		print "Completed Problem 1!"
	else:
		print error

#Fixed XOR
#http://cryptopals.com/sets/1/challenges/2/
#Hex1: 1c0111001f010100061a024b53535009181c
#Hex2: 686974207468652062756c6c277320657965
#Expecting: 746865206b696420646f6e277420706c6179
def problem2():
	hex1 = "1c0111001f010100061a024b53535009181c"
	hex2 = "686974207468652062756c6c277320657965"
	expected = "746865206b696420646f6e277420706c6179"
	print "Xoring " + hex1 + " and " + hex2
	print "Expecting " + expected
	answer = xor(hex1,hex2)
	#Removes 0x and the L (long) on the answer
	print "Received: " + answer
	if answer == expected:
		print "Completed Problem 2"
	else: 
		print error

def problem3():
	
	given = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736"
	print char_freq_decoder(given)

def problem4():
	for line in open("4.txt").readlines():
			if line[len(line)-1:] == "\n":
				cipher= line[:len(line)-1]
			else:
				cipher = line
			#print "\nSolving: "+cipher
			answer = char_freq_decoder(cipher)
			if answer != "":
				print "Lowest Answer: " + answer
   


			
	

def main():
	print "\nProblem 1"
	problem1()
	print "\nProblem 2"
	problem2()
	print "\nProblem 3"
	problem3()
	print "\nProblem 4"
	problem4()


if __name__ == '__main__':
	main()

