import sys
import os

#Stores file data into variable reader
reader = os.stat(sys.argv[1])
#Prints file size
print reader.st_size
