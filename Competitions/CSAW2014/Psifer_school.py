#!/usr/bin/env python
import time
def decipher(encrypted, shifts):
        to_array = list(encrypted)
        answer = "";
        for k in to_array:
                if ord(k) == 32:
                        answer += k
                else:
                        shifted = (ord(k)+shifts) % 123
                        if ((shifted < 97) or (shifted > 122)):                                                 shifted += 97
                        #print shifted
                        answer += chr(shifted)

      	return answer

def stage2(encrpted, n):
	answer =""
	temp = list(encrpted)
	for x in range(0,n):
		for y in range(x, len(encrpted), n):
			answer+=temp[y]
	if "I hope you don't have " in answer:
	    print "-------------------------------- THIS ONE !!! "
	return answer
#CD TO WHEREVER THIS IS LOCATED IN RUN THE COMMAND "python defcon.py" TO RUN

import socket

#Was trying to hack one of the trackers for the torrent one. replace this with the website u want to connect to
host="54.209.5.48"

#the port with whatever u want 
port = 12345


data = ""

#ipv6 code (cudnt get it to work) no need for it usually
#data2 = socket.getaddrinfo(host, port, socket.AF_INET6 ,0,socket.SOL_TCP)

#creates a socket
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
#connets to socket
s.connect((host, port))

#the data u want to send 

#recieves data and stores it
print s.recv(1024)
data2 = s.recv(1024)
print data2
temp = len(data2)-1
whole = data2[102:]
cipher = data2[102:129]
answer = data2[130:temp]
first = data2[102:103]
time.sleep(0.5)
print "Deciphering: "+ whole
for x in range(1,26):
	if decipher(cipher,x) == "the answer to this stage is":
		print "Sucess: "+decipher(whole,x) +"\n"
		print "Sending: "+decipher(answer,x) +"\n"
		s.send(decipher(answer,x)+ "\n")
		break
time.sleep(0.5)
data3 =  s.recv(1024)
print data3
answer  =  data3[186:]
#print "Deciphering: " + answer +"\n"
for x in range(1,100):
    capture = stage2(answer, x)
    if "I hope you don't have " in capture:
        print capture
        answer2 = capture[167:len(capture)-54]
        print answer2
        s.send(answer2+ "\n")
time.sleep(0.5)
data4 =  s.recv(1024)
print data4
#	if decipher(ccipher,x) == "the${nswer$to$this$st{ge$is$":
#		print decipher(answer,x)
		
	
#-11esp lydhpc ez estd delrp td szapjzflfezxlep
#u parobly wnna do some type of for loop with if statements with ur data #also itd be good to print out eveyrthing that happens so u can see what happens through terminal


#for x in range(0,127):
 #       print decipher(cipher,x)
  #      print decipher(answer,x)

