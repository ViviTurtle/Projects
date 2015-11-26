Boston Key Party CTF 2015
=========================

[Haymarket](Haymarket)
---------

**Category:** Reversing **Points:** 150 **Solves:** 216 **Description:**

>Monty Hall wrote a script of how he was supposed to run one of his game shows for his 
>trusty accounting computer some time ago, but hes not really sure what the punch 
>cards mean any more. I mean,that was a while ago. Only, hes sure his key is 
>hidden somewhere in these punch-cards,if he could figure out how to run them...


BKPCTF_INTRO
----------------
 Simple binary the SJSU: InfoSec Club president put together to let us know the location of our meeting for BKPCTF
 
 I ran strings against it, and it gave me a bunch of text with one area of interest
  ```
  ...
  bro, if you don't get this...
592c094d5574fb32fe9d4cce27240588
rh0gue
tfwnogf
base-64 is useful
pwnzor
ZmxhZ3tjb25ncmF0cyEgcGxlYXNlIG1lZXQgb24gMi8yOCBpbiB0aGUgTUxLIGxpYnJhcnkgcm9vbSAzOTIgQCAxIFBNfQ==
Yo dawg, I heard you want to capture some flags w/ Spartan Security. Think you've got what it takes? (Yes/No)
omgy0ukn0wh0wtousestrings?hax!!
WRONG ANSWER!...
```
**base-64 is useful**  and **ZmxhZ3tjb25ncmF0cyEgcGxlYXNlIG1lZXQgb24gMi8yOCBpbiB0aGUgTUxLIGxpYnJhcnkgcm9vbSAzOTIgQCAxIFBNfQ==** Seems like something to take a look at

I ran base64 -d on the encoded data and got flag{congrats! please meet on 2/28 in the MLK library room 392 @ 1 PM}
