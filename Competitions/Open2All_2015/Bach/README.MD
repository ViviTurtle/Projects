BACH: CRYPTO 150
----------------------

>Well, not quite...
>Author: Eriner

Note: the format is flag{secret_goes_here}
8aec78b8dca5541b69d07404f1a6be68.tar.bz2

![GitHub Logo](https://github.com/Flippinunit/Programming/blob/master/Competitions/Open2All_2015/Bach/f4923a0aa2a3cc07026e38f41b3cd673.png)

Sight reading decoded
FA#E _FE#AG_B#E _ EDB#G#EDEF#GED#EAE#F#AEFEDBB#ECE

Possible translation?
The Flag is .... EDINEDEMGEKEALMAEFEDBIECE

Possible Combinations, Tried iterating everyone.
Later saw the use for naturals in the png, and solved the code.

ABCDEFG NORMALS
HIJKLMN SHARPS
OPQRSTU NATURALS
VWXYZ   FLATS

Looking at the PNG and this key
ERINERS MUSICAL MASTERPIECE! <- Omg it worked
Key = Flag{erinsersmusicalmasterpiece}


|Normal|A|B|C|D|E|F|G|
|------|-----|----|-----|-----|-----|-----|-----|
|**Sharps**|H|I|J|K|L|M|N|
|**Naturals**|O|P|Q|R|S|T|U|
|**Flats**|V|W|X|Y|Z|

Bruteforce.py
 ~ I had tried to brute force every possible iteration the code could become, but then I dropped this as it took too long.
```python

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

