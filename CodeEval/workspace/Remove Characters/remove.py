import sys

#opens file
test_cases = open(sys.argv[1], 'r')
for test in test_cases:
	#splits the cipher and key
   	split = test.split(',')
   	#stores key
   	key = split[1]
   	key = key.strip()
   	for letters in list(key):
   		split[0] = split[0].replace(letters,'')
   	print split[0]

test_cases.close()