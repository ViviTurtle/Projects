Math is Hard: MISC 200
------------------------

>104.131.107.153:12121

>Author: gaffe

This was a time consuming socket programming challenge. Given we were only given an IP and a port, I had assumed we should netcat into it. When you netcat into 104.131.107.153 on port 12121 we are greeted with a message.

>Hey dude, can you help me with my math homework? I have a few addition problems to do...

>You have 10.000000 seconds to solve this problem: 389 + -40

Inserting the answers to this greets us with another question (The integers were always random).

>You have 6.666667 seconds to solve this problem: -823 + -777

From this we can assume two things. This problem is going to get harder and harder as time goes on, and we well have almost to do this at an impossible time. So what do we do? We pull out Python and make a script. If you guys know python you should know you can make socket connections using python.


'''
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

