import sys

#opens file
test_cases = open(sys.argv[1], 'r')
for test in test_cases:
	#resets answer
	answer = ''
	#cleans strings for newlines
	test = test.replace('\n','')
	#splits the cipher and key
   	split = test.split('|')
   	#stores cipher
   	cipher = split[0]
   	#stores key
   	locations = split[1].split()
   	for index in locations:
   		#add letter to answer according to index
   		answer=answer + cipher[int(index)-1:int(index)-2]
   	print answer

test_cases.close()