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
import Image
import sys

#Row 1, Column 1 = (17,24)
START_PIXEL_X = 17
START_PIXEL_Y = 24
#Next row/column was (7,20)
X_NEXT_PIXEL = 7
Y_NEXT_PIXEL = 20

TOTAL_ROWS = 12
TOTAL_COLUMNS = 80

#Looked at Color from GIMP
# 588x264 All pictures
#20,20,20,255 = bulleted
#235,230,172,255 = yellow background
#60,60,60,255 = digit color


def getASCII(index1, index2, index3):
	if index1 == 1:
		if index2 == 4:
			return 'a'
		elif index2 == 5:
			return 'b'
		elif index2 == 6:
			if index3 == 11:
				return '.'
			else: return 'c'
		elif index2 == 7:
			if index3 == 11:
				return '<'
			else: return 'd'
		elif index2 == 8:
			if index3 == 11:
				return '('
			else: return 'e'
		elif index2 == 9:
			if index3 == 11:
				return '+'
			else: return 'f'
		elif index2 == 10:
			return 'g'
		elif index2 == 11:
			return 'h'
		elif index2 == 12:
			return 'i'
		elif index2 == 0:
			return '&'
	elif index1 == 2:
		if index2 == 4:
			return 'j'
		elif index2 == 5:
			if index3 == 11:
				return '!'
			else: return 'k'
		elif index2 == 6:
			if index3 == 11:
				return '$'
			else: return 'l'
		elif index2 == 7:
			if index3 == 11:
				return '*'
			else: return 'm'
		elif index2 == 8:
			if index3 == 11:
				return ')'
			else: return 'n'
		elif index2 == 9:
			return 'o'
		elif index2 == 10:
			return 'p'
		elif index2 == 11:
			return 'q'
		elif index2 == 12:
			return 'r'
		elif index2 == 0:
			return '-'
	elif index1 == 3:
		if index2 == 5:
			return 's'
		elif index2 == 4:
			return '/'
		elif index2 == 6:
			if index3 == 11:
				return ','
			else:return 't'
		elif index2 == 7:
			if index3 == 11:
				return '%'
			else: return 'u'
		elif index2 == 8:
			return 'v'
		elif index2 == 9:
			if index3 == 11:
				return '>'
			else: return 'w'
		elif index2 == 10:
			if index3 == 11:
				return '?'
			else: return 'x'
		elif index2 == 11:
			return 'y'
		elif index2 == 12:
			return 'z'
	elif index1 == 4:
		return '1'
	elif index1 == 5:
		if index2 == 11:
			return ':'
		else: return '2'
	elif index1 == 6:
		if index2 == 11:
			return '#'
		else: return '3'
	elif index1 == 10:
		if index2 == 11:
			return '"'
		else: return '7'

	elif index1 == 8:
		if index2 == 11:
			return ''
		else: return '5'
	elif index1 == 9:
		if index2 == 11:
			return '='
		else: return '6'
	elif index1 == 7:
		if index2 == 11:
			return '@'
		else: return '4'
	elif index1 == 11:
		return '8'
	elif index1 == 12:
		return '9'
	elif index1 == 0:
		return ''
	return '~'

from PIL import Image
im = Image.open(sys.argv[1]) #Can be many different formats.
pix = im.load()
rgb_im = im.convert('RGB')
r,g,b = rgb_im.getpixel((START_PIXEL_X,START_PIXEL_Y))
stringbuilder = ''
for x in range (1,TOTAL_COLUMNS+1):
	#resets indexes (0 = blank, not used)
	#i.e. 6,0,0 means only a black spot a row 0, nothing else)
	bulletedindex=[0,0,0]
	count = 0
	for y in range (1,TOTAL_ROWS+1):
		#4,10 are offseed for the image
		3Sets RGBS
		r,g,b = rgb_im.getpixel((X_NEXT_PIXEL*x+10,Y_NEXT_PIXEL*y+4))
		#20,20,20 is the color for a bullet
		if r == 20 and g == 20 and b == 20:
			#keeps index parallel to current row
			bulletedindex[count]= y 
			count = count + 1
	#builds the string
	stringbuilder = stringbuilder + getASCII(bulletedindex[0],bulletedindex[1],bulletedindex[2])
print stringbuilder
