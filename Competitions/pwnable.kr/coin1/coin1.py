#!/usr/bin/env python
import time
import socket
import re

#Was trying to hack one of the trackers for the torrent one. replace this with the website u want to connect to
host="pwnable.kr"
#the port with whatever u want 
port = 9007


data = ""

#ipv6 code (cudnt get it to work) no need for it usually
#data2 = socket.getaddrinfo(host, port, socket.AF_INET6 ,0,socket.SOL_TCP)

#creates a socket
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
#connets to socket
s.connect((host, port))
print s.recv(2058)
time.sleep(4)
data = s.recv(2058)

coin(data)


#the data u want to send 

#recieves data and stores it

