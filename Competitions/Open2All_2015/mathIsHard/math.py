#!/usr/bin/env python
import time
import socket
import re

#Was trying to hack one of the trackers for the torrent one. replace this with the website u want to connect to
host="104.131.107.153"
#the port with whatever u want 
port = 12121


data = ""

#ipv6 code (cudnt get it to work) no need for it usually
#data2 = socket.getaddrinfo(host, port, socket.AF_INET6 ,0,socket.SOL_TCP)

#creates a socket
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
#connets to socket
s.connect((host, port))

#the data u want to send 

#recieves data and stores it

def add(int1, int2):
	return int(int1) + int(int2)
#	elif operator == '-':
#		return int(int1) - int(int2)

def mult(int1, int2):
	return int(int1) * int(int2)

def sub(int1, int2):
	return int(int1) - int(int2)

def div(int1,int2):
	return int(int1) / int(int2)

def exp(int1,int2):
	answer = 1
	for i in range (0,int(int2)):
		answer = answer*int(int1)
	return answer 

def exp_parse(function,x_fixed):
	x_index = function.find('x')
	if x_index == -1:
		return 0
	elif len(function) < x_index + 2:
		return function[0:1]
	else:
		base = function[0:1]
		exponent = function[3:4]
		answer = exp(x_fixed,int(exponent)-1)
		answer = mult(answer,base)
		answer = mult(answer,exponent)
		return answer
	

print s.recv(1024)

#Solves the first set of additions
for x in range (0,8):
	data2 = s.recv(1024)
	print data2
	test =  data2[data2.index(':')+1:]
	store =  test.split()
	answer =  add(store[0],store[2])
	print answer
	s.send(str(answer) + '\n')

print s.recv(1024)

#Linear Equations
for z in range (0,8):
	
	data3 = s.recv(1024)
	#They changed the formatting after the initial iteration Thus this portion of code only works for z = 0
	if z == 0:
		print data3
		#print 'Data3: ' + data3
		test =  data3[data3.index(':')+1:]
		#print 'test:' + test
		store3 =  test.split()
	else: 
		store3 = data3.split()
		print test
	x1 = store3[0]
	x2 = store3[5]
	y1 = store3[2]
	y2 = store3[7]
	s1 = store3[4]
	s2 = store3[9]
	x = sub(mult(x1[0:len(x1)-1], y2[0:len(y2)-1]),mult(x2[0:len(x2)-1], y1[0:len(y1)-1]))
	s3 = sub(mult(s1[0:len(s1)], y2[0:len(y2)-1]),mult(s2[0:len(s2)], y1[0:len(y1)-1]))
	#print x,s3
	answer = div(s3,x)
	print str(answer)
	s.send(str(answer) + '\n')
	#print  mult(x1[0:len(x1)-1],answer)
	answer2 = div(sub(int(s1),mult(x1[0:len(x1)-1],answer)),y1[0:len(y1)-1])
	print s.recv(1024)
	print str(answer2)
	s.send(str(answer2) + '\n')
	print s.recv(1024)

#Last portion was not consistant at all in iterations
#Calulus Problems
data2 = s.recv(1024)
print data2
#First iteration
test =  data2[data2.index('for')+1:]
store =  test.split()
#print store
x = store[3]
answer = exp_parse(store[6], x[0:1])
print answer
s.send(str(answer) + '\n')
temp = s.recv(1024)
print temp
temp2 = s.recv(1024)
print temp2
data2 = temp + temp2

#2-5 Iteration
for p in range (1,5):
	answer = 0
	test =  data2[data2.index('for')+1:]
	store =  test.split()
	#print store
	x = store[3]
	for q in range(1,4+2*p):
		answer = answer + exp_parse(store[4+q*2], x[0:1])
	print answer
	s.send(str(answer) + '\n')
	temp = s.recv(1024)
	print temp
	temp2 = s.recv(1024)
	print temp2
	data2 = temp + temp2


#Sixth iteration
answer = 0
test =  data2[data2.index('for')+1:]
store =  test.split()
#print store
x = store[3]
answer = answer + exp_parse(store[6], x[0:1])
answer = answer + exp_parse(store[8], x[0:1])
answer = answer + exp_parse(store[10], x[0:1])
answer = answer + exp_parse(store[12], x[0:1])
answer = answer + exp_parse(store[14], x[0:1])
answer = answer + exp_parse(store[16], x[0:1])
answer = answer + exp_parse(store[18], x[0:1])
answer = answer + exp_parse(store[20], x[0:1])
answer = answer + exp_parse(store[22], x[0:1])
answer = answer + exp_parse(store[24], x[0:1])
print answer
s.send(str(answer) + '\n')
temp = s.recv(1024)
print temp
temp2 = s.recv(1024)
print temp2
data2 = temp + temp2

#Seventh iteration
answer = 0
test =  data2[data2.index('for')+1:]
store =  test.split()
#print store
x = store[3]
answer = answer + exp_parse(store[6], x[0:1])
answer = answer + exp_parse(store[8], x[0:1])
answer = answer + exp_parse(store[10], x[0:1])
answer = answer + exp_parse(store[12], x[0:1])
answer = answer + exp_parse(store[14], x[0:1])
answer = answer + exp_parse(store[16], x[0:1])
answer = answer + exp_parse(store[18], x[0:1])
answer = answer + exp_parse(store[20], x[0:1])
answer = answer + exp_parse(store[22], x[0:1])
answer = answer + exp_parse(store[24], x[0:1])
answer = answer + exp_parse(store[26], x[0:1])
print answer
s.send(str(answer) + '\n')
temp = s.recv(1024)
print temp
temp2 = s.recv(1024)
print temp2
data2 = temp + temp2

#Eigth iteration
answer = 0
test =  data2[data2.index('for')+1:]
store =  test.split()
#print store
x = store[3]
answer = answer + exp_parse(store[6], x[0:1])
answer = answer + exp_parse(store[8], x[0:1])
answer = answer + exp_parse(store[10], x[0:1])
answer = answer + exp_parse(store[12], x[0:1])
answer = answer + exp_parse(store[14], x[0:1])
answer = answer + exp_parse(store[16], x[0:1])
answer = answer + exp_parse(store[18], x[0:1])
answer = answer + exp_parse(store[20], x[0:1])
answer = answer + exp_parse(store[22], x[0:1])
answer = answer + exp_parse(store[24], x[0:1])
answer = answer + exp_parse(store[26], x[0:1])
print answer
s.send(str(answer) + '\n')
temp = s.recv(1024)
print temp
temp2 = s.recv(1024)
print temp2
data2 = temp + temp2









