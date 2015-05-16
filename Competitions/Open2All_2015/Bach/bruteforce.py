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