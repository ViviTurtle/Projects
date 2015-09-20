#!/usr/bin/envzz

## Author: Vivi Langga

#Problems are taken from the Matasano Crpyo Challenges


import re
import sys
import unittest
import binascii
import numpy as np

from crypto_defs import *
prob4_lowest = 1000
prob4_answer = ""




# Convert hex to base64
#http://cryptopals.com/sets/1/challenges/1/
#Hex: 	 
#b64: SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t
def problem1():
	given = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d"
	expected = "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t"
	answer =  hex2b64(given)
	print "Expecting: " + expected
	print "Recieved: " + str(answer)	
	assert (expected == answer), "Problem 1: Fail"
	print binascii.unhexlify(given)

#Fixed XOR
#http://cryptopals.com/sets/1/challenges/2/
#Hex1: 1c0111001f010100061a024b53535009181c
#Hex2: 686974207468652062756c6c277320657965
#Expecting: 746865206b696420646f6e277420706c6179
def problem2():
	hex1 = "1c0111001f010100061a024b53535009181c"
	hex2 = "686974207468652062756c6c277320657965"
	expected = "746865206b696420646f6e277420706c6179"
	
	print "Xoring: " + hex1 + " and " + hex2
	print "Expecting " + expected
	answer = xor(hex1,hex2)
	#Removes 0x and the L (long) on the answer
	print "Received: " + answer
	assert (answer == expected) , "Problem 2: Fail" 
	print binascii.unhexlify(answer)

def problem3():
	
	given = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736"
	expected = "cooking mc's like a pound of bacon"
	print "Analyzing character frequency of single character xor for: " + given
	print "Expecting: "+ expected
	answer = single_char_xor_solver(given)
	answer2 = answer.split('applesareawesome')
	print "Received: " + answer2[0]
	assert (answer2[0] == expected) , "Problem 3: Fail"
	print "Problem 3: Pass"
	

	"cooking mc's like a pound of bacon"
	"sjsusjsusjsusjsusjsusjsu"


def problem4():
	print "Analyzing character frequency of single character xor for File: 4.txt"
	expected = "now that the party is jumping*"
	lowest = float(1000)
	real_answr =""
	for line in open("4.txt").readlines():
			if line[len(line)-1:] == "\n":
				cipher= line[:len(line)-1]
			else:
				cipher = line
			#print "\nSolving: "+cipher
			answer = single_char_xor_solver(cipher)
			answer2 = answer.split('applesareawesome')
			if lowest > float(answer2[1]):
				print "Replaced final score " + str(lowest)+" with " + answer2[1] + " with an answer of " + answer2[0]

				lowest = float(answer2[1])
				real_answr = answer2[0]
	print "Expecting: "+ expected
	print "Final Answer: " + real_answr
	assert (real_answr == expected) , "Problem 4: Fail"
	print "Problem 4: Pass"

def problem5():
	given = "Burning 'em, if you ain't quick and nimble\nI go crazy when I hear a cymbal"
	expected = "b3637272a2b2e63622c2e69692a23693a2a3c6324202d623d63343c2a26226324272765272a282b2f20430a652e2c652a3124333a653e2b2027630c692b20283165286326302e27282f"
	key = "ICE"
	answer = xor(given.encode("hex"),key.encode("hex"))
	print "Expecting: "+ expected
	print "Final Answer: " + answer
	assert (answer == expected) , "Problem 5: Fail"
	print "Problem 5: Pass"

def problem6():
	#for x in range(0, 40):
	#	single_char_xor_solver
	#Converts file from base64 to hex and removes trailing '\n' from each line
	new_file = ""
	line = open("6.txt").read()
		#print line
	line = line.decode("base64").encode("hex")
	lowest = 10000
	lowest4 = {
		"low1" : 1000,
		"low2" : 1000,
		"low3" : 1000,
		"low4" : 1000	
	} 
	a = np.array([[]])
	b = np.array([])
	for keysize in range (1,40):
		index = 0
		if keysize * 8 > len(line):
			keysize = 40
		else: 
			ham = float(0)
			for x in range (0,2):
				hex1 = line[index*keysize:index*keysize+keysize]
				index += 2
				hex2 = line[index*keysize:index*keysize+keysize]		
				index += 2
			 	ham =+ float(find_hamming_weight(hex1,hex2))
		ham = ham /2.0/float(keysize)
		b = np.array([[ham ,keysize]])
		#print b
		a = np.concatenate((a, b),axis = 0)
	print a
	#a.sort(axis = 0)
	#print "-------"
	#print a
	#print a 
	#print sorted(b)
	#a = np.append(a, [[b]])
	#print a
	#a.sort(axis = 0)
	#print b
	#print "-------------------"
	#print a
	#print "-------------------"
	#a = np.array([[1,4], [3,1]])
	#a = np.append(a, [[[1,5]])
	#a.sort(axis=0)
	#print a
	#for x in a:
	#	print x
			#lowest4["low1"] = ham
		#print lowest4
			#lowest = ham
			#poop = keysize

	#print 
	#print ham
	#for x in np.sort(a)[0:4]:
	#	print x[0]
	#print tup[0:2]


	#print "Keysize: " + str(poop)
		#temp = find_hamming_weight(hex1,hex2)/keysize
		#print temp

def main():
	#print "\nProblem 1"
	#problem1()
	#print "\nProblem 2"
	#problem2()
	#print "\nProblem 3"
	#problem3()
	#print "\nProblem 4"
	#problem4()
	#print "\nProblem 5"
	#problem5()
	print "\nProblem 6"
	problem6()

if __name__ == '__main__':
	main()
