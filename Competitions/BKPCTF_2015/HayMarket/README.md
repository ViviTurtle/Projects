Haymarket: Reversing 150 Writeup ~ BKPCTF 2015
===============================================

>Monty Hall wrote a script of how he was supposed to run one of his game shows for his trusty accounting computer some time ago, but hes not really sure what the punch cards mean any more. I mean,that was a while ago. Only, hes sure his key is hidden somewhere in these punch-cards,if he could figure out how to run them...


**Please refer to following link for my original writeup**

http://poopooturtle.blogspot.com/2015/03/haymarket-reversing-150-writeup-bkpctf.html

Note: This is below copied from my blogspot, and fixed for github

This challenge was a fairly easy Reversing challenge. In simple terms all you had to do was read a a set of punch cards. We were first given this description. Monty Hall wrote a script of how he was supposed to run one of his game shows for his trusty accounting computer some time ago, but hes not really sure what the punch cards mean any more. I mean, that was a while ago. Only, hes sure his key is hidden somewhere in these punch-cards, if he could figure out how to run them...*

Along with a link to  
http://bostonkeyparty.net/haymarket.tar.gz.fe35f59bfa869a0555e9972efa3ddd2d.

If the above link is down, you can probably get it at https://github.com/Flippinunit/Programming/blob/master/Competitions/BKPCTF_2015/HayMarket/haymarket.tar. 

So, after renaming the file to haymarket.tar.gz and extracting it via cmd line with "tar -zxvf haymarket.tar.gz" We were given 32 PNG's of punch cards. ![Punchcard 1](https://github.com/Flippinunit/Programming/blob/master/Competitions/BKPCTF_2015/HayMarket/Haymarket_images/L1.png)

![Punchcard 20](https://github.com/Flippinunit/Programming/blob/master/Competitions/BKPCTF_2015/HayMarket/Haymarket_images/L20.png)

Doing what we hackers do best, I went and Googled how to read Punch Cards. I eventually found this fairly descriptive History of Punchcards (http://www.masswerk.at/keypunch/) . Sorry, but I have no time to read history. After more Googling, I found this virtual keyboard (http://www.masswerk.at/keypunch/). I figured I take my chances here and quickly learn the translation of keys to bullet points. Indeed, the translation went well. I quickly typed out every letter and every available punctuation to get a quick translation. 


![Virtual Keyboard](https://github.com/Flippinunit/Programming/blob/master/Competitions/BKPCTF_2015/HayMarket/Haymarket_images/Keyboard.png)


Now that I had the translation of bullets to ASCII, I just had to write a program. I Googled how to read images from Python and it was fairly simple. Using that code I got to business. I was of course missing things like rows, columns, RGB color, and pixel offesets. Most of these I was able to get looking at each image in GIMP's (a very bad free Linux version of Photoshop in my opinion) color picker and image properties. 


![Virtual Keyboard](https://github.com/Flippinunit/Programming/blob/master/Competitions/BKPCTF_2015/HayMarket/Haymarket_images/GIMP.png)

The hosts were kind enough to provide us with a uniform size and offset for each row and column. The first bullet was at (17,24), the next column was 7 pixels across, and the next row was 20 pixels down. The color of the bullets were RGB (20,20,20). All that was left was a simple nested for loop of recording RGB's and translating their row locations to ASCII. If you want to see the output for all the PNG's you can find it at My GitHub. After running my script on all the PNGs you get to a line that says display key(set alextrebekisasocialengineer) and indeed "alextrebekisasocialengineer" is the flag. Congratulations! I did it.

In conclusion, I would like to thank Boston Key Party 2015 for this great challenge. It was a great way for me to refresh my Python programming while learning about punch cards. Again I look forward for next years competition.


Punchcard.py
```python
Note: I ignored the numbers and just went from 1-13 rows with zero's as the default value.

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

#Translates indexes to ASCII
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
#For each column
for x in range (1,TOTAL_COLUMNS+1):
 #resets indexes (0 = blank, not used)
 #i.e. 6,0,0 means only a black spot a row 0, nothing else)
 bulletedindex=[0,0,0]
 count = 0
 #For Each row
 for y in range (1,TOTAL_ROWS+1):
  #4,10 are offseed for the image
  #Sets RGBS
  r,g,b = rgb_im.getpixel((X_NEXT_PIXEL*x+10,Y_NEXT_PIXEL*y+4))
  #20,20,20 is the color for a bullet
  if r == 20 and g == 20 and b == 20:
   #keeps index parallel to current row
   bulletedindex[count]= y 
   count = count + 1
 #builds the string
 stringbuilder = stringbuilder + getASCII(bulletedindex[0],bulletedindex[1],bulletedindex[2])
print stringbuilder
```
