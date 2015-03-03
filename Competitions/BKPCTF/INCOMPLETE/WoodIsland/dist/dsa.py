from dsa_prime import SAFEPRIME, GENERATOR
from dsa_key import PUBKEY, SECKEY

import hashlib

def elgamal_verify(r, s, m):
    if r <= 0 or r >= SAFEPRIME:
        return False
    if s <= 0 or s >= SAFEPRIME-1:
        return False
    h = int(hashlib.sha384(m).hexdigest(), 16)
    left = pow(GENERATOR, h, SAFEPRIME)
    right = (pow(PUBKEY, r, SAFEPRIME) * pow(r, s, SAFEPRIME)) % SAFEPRIME
    return left == right

DUPLICATES = []

def is_duplicate(s):
    return s in DUPLICATES

import base64, SocketServer, os, sys, json

class ServerHandler(SocketServer.BaseRequestHandler):

    def fail(self, message):
        self.request.sendall(message + "\nGood-bye.\n")
        self.request.close()
        return False

    def captcha(self):
        proof = base64.b64encode(os.urandom(9))
        self.request.sendall(proof)
        test = self.request.recv(20)
        ha = hashlib.sha1()
        ha.update(test)
        if test[0:12]!=proof or not ha.digest().endswith('\xFF\xFF\xFF'):
            self.fail("You're a robot!")

    def handle(self):
        self.captcha()
        sig = self.request.recv(5000)
        sig = json.loads(sig)
        if "r" not in sig or "s" not in sig or "m" not in sig:
            self.request.close()
            return
        r = sig["r"]
        s = sig["s"]
        m = sig["m"]
        if not elgamal_verify(r, s, m):
	    print 'sig error'
            self.request.close()
        elif is_duplicate(sig):
	    print 'dup error'
            self.request.close()
        elif m != "There is no need to be upset":
            print 'upset'
            self.request.close()
        else:
            self.request.sendall(FLAG)
            self.request.close()


class ThreadedServer(SocketServer.ThreadingMixIn, SocketServer.TCPServer):
    pass

            


FLAG = ""

if __name__ == "__main__":
    HOST = sys.argv[1]
    PORT = int(sys.argv[2])

    FLAG = open('flag.txt', 'r').read()
    DUPLICATES = open('sigs.txt', 'r').read().split('\n')[:-1]
    DUPLICATES = map(json.loads, DUPLICATES)
    
    server = ThreadedServer((HOST, PORT), ServerHandler)
    server.allow_reuse_address = True
    server.serve_forever()
    
