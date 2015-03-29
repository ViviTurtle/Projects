Math is Hard: MISC 200
------------------------

>104.131.107.153:12121

>Author: gaffe

This was a time consuming socket programming challenge. Given we were only given an IP and a port, I assumed we should netcat into it. When you netcat into 104.131.107.153 on port 12121 we are greeted with a message.

>Hey dude, can you help me with my math homework? I have a few addition problems to do...

>You have 10.000000 seconds to solve this problem: 389 + -40

Inserting the answers to these questions greets us with another question (The integers were always random).

>You have 6.666667 seconds to solve this problem: -823 + -777

From this we can assume two things. This problem is only going to get harder and harder as time goes on, and we will have to do this in an impossible time. In fact it did, towards the end I had to do Linear Equations in half a second. So what do we do? We pull out Python and make a script. If you guys know python you should know you can make socket connections using python similar code below.


```python
#!/usr/bin/env python
import time
import socket
import re
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
s.recv(); 
s.send("test\n")
```

Using a script called math.py, I was able to slowly automate it using a lot of "print s.recv(1024)" and defined functions. The first eight problems were all addition. So I just looped through it 8 times. 

```python
data2 = s.recv(1024)
print data2
test = data2[data2.index(':')+1:]
store = test.split()
#the two digits were stored in index 0 and 2
answer = add(store[0],store[2])
print answer
s.send(str(answer) + '\n')
```

>...

>You have 0.585277 seconds to solve this problem: -3680552 + -4035312

>-7715864

>Hey, nice job! Okay, we're done with the addition part, now it's going to get harder:

The next eight problems were Linear Equations. 

>You have 10.000000 seconds to solve the following system of equations:

>-925x + -670y = -105565

>734x + -737y = -293023

>Enter the value of x:

Given I am a Math minor, I made a function to solve linear equations using substrings to pull out the digits and using a similar function like addition. I pulled each digit out, and solved for x and y using multiplcation, addition, subtraction etc.... 

>You have 0.585277 seconds to solve the following system of equations:

>-925x + -670y = -105565

>734x + -737y = -293023

>Enter the value of x:

>2287667

>Enter the value of y:

>546000

Lastly they gave me Calculus problems to solve. 

>Thanks man. Hey uh, also, how much do you know about calculus?

>You have 10.000000 seconds to calculate the derivative of the following equation for x = 6:

>f(x) = 7x^4

>Enter the value of f'(x):

Again I made a script to pull out digits from the numbers and solved each question. After the final iteration, we are greeted with a message 

>Hey, thanks buddy! Here's a little somethin' for your trouble: flag{l3ts_g0_shOpP1ng}

With this we were given the flag to gain the team another 200 points! Wohoo. The final code is found below. The final ouput was also saved at https://github.com/Flippinunit/Programming/blob/master/Competitions/Open2All_2015/mathIsHard/Netcat_output_Final.

```python
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
# elif operator == '-':
# return int(int1) - int(int2)
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
test = data2[data2.index(':')+1:]
store = test.split()
answer = add(store[0],store[2])
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
test = data3[data3.index(':')+1:]
#print 'test:' + test
store3 = test.split()
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
#print mult(x1[0:len(x1)-1],answer)
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
test = data2[data2.index('for')+1:]
store = test.split()
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
test = data2[data2.index('for')+1:]
store = test.split()
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
test = data2[data2.index('for')+1:]
store = test.split()
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
test = data2[data2.index('for')+1:]
store = test.split()
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
test = data2[data2.index('for')+1:]
store = test.split()
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
data2 = temp +
temp2
```
