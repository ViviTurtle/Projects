#!/usr/bin/env python

import sys
from binascii import unhexlify

import base64

lvl1 = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d"

def get_bytes(input):
	return unhexlify(input)

def get_bas64(input):
	return base64.b64encode(input)

print get_bytes(lvl1)