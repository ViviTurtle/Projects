BACH: CRYPTO 150
----------------------

>Well, not quite...
>Author: Eriner

This challenge was quite a simple Cryptography challenge given that it requires zero knowledge of ciphers or anything else related to cryptopgrahy. We were given a link to download the file : 8aec78b8dca5541b69d07404f1a6be68.tar.bz2 which contained a single image.

![GitHub Logo](https://github.com/Flippinunit/Programming/blob/master/Competitions/Open2All_2015/Bach/f4923a0aa2a3cc07026e38f41b3cd673.png)

Given my piano background, I began to read the notes for what they were ignoring all the naturals thinking they had nothing to do with the code.

Sight reading:

>FA#E _FE#AG_B#E _ EDB#G#EDEF#GED#EAE#F#AEFEDBB#ECE

Given that that there are four words my guess would be that it would contain some kind of sentence. If you look at the second word, F-E#-A-G, it almost makes out to the word "FLAG". I began looking for a pattern and I noticed the "E#" would be considered an "L" which is one full cycle of 7 notes after "E". In other words, given that A-G were given, than "A" can also be "H", and "B" can be "I" and so forth. I looked further into this and tried deciphering the rest of the words.My possible guess for this was


>The Flag is .... EDINEDEMGEKEALMAEFEDBIECE

I then wrote a script called bruteforce.py to bruteforce the last word because I had thought it would take too long to guess every possible combination if I tried guessing that "E" can be "L", "S" or "Z" and "A" can be "H "O" and "V". After about 5 minutes, I canceled the script because I realized it would take too long. I looked back at the image and was curious about why the naturals were there.I then saw the pattern!

|Normal|A|B|C|D|E|F|G|
|------|-----|----|-----|-----|-----|-----|-----|
|**Sharps**|H|I|J|K|L|M|N|
|**Naturals**|O|P|Q|R|S|T|U|
|**Flats**|V|W|X|Y|Z|

Deciphering the image, the sentence says, the flag is erinsersmusicalmasterpiece. I inserted "Flag{erinsersmusicalmasterpiece}" to score my club another 150 points in the CTF.

Bruteforce.py

```python
#!/usr/bin/env python

import sys
#at first tried printing every iteration
flag_encrypted = 'EDINEDEMGEKEALMAEFEDBIECE'
A = ['A','O','V']
B = ['B','P','W']
C = ['C','Q','X']
D = ['D','R','T']
E = ['E','S','Z']
F = ['F','T','T']
G = ['N','U','U']
permutations=[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
def getLetter(letter,index):
	if letter == 'A':
		return A[index]
	elif letter == 'B':
		return B[index]
	elif letter == 'C':
		return C[index]
	elif letter == 'D':
		return D[index]
	elif letter == 'E':
		return E[index]
	elif letter == 'F':
		return F[index]
	elif letter == 'G':
		return G[index]
	else: return letter

def done():
	for x in range (0,25):
		if not permutations[x] == 2:
			return False
	return True
def next(index):
	if permutations[index] == 2:
		permutations[index] = 0
		next(index + 1)
	else: permutations[index] = permutations[index] + 1
while not done():
	stringbuilder = ''
	for x in range (0,len(flag_encrypted)):
		stringbuilder = stringbuilder  + getLetter(flag_encrypted[x],permutations[x])
	print 'The Flag is ' + stringbuilder
	next(0);

