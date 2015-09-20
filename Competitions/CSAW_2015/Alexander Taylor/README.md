Alexander Taylor: Recon 100
---------

> [http://fuzyll.com/csaw2015/start](http://fuzyll.com/csaw2015/start)

Yay more Recon. For those that don't know what recon is, it is pretty much what you would call information gathering. You always do recon when you first do a pentest to get a scope of your target. In that way, the more information you have, the better ways you can exploit weaknesses, whether the weakness is a phishing attack or some physical penetration test. In this question we have to do some Reconnaissance on Alexander Taylor. 

This time around we are given a link. 

[http://fuzyll.com/csaw2015/start](http://fuzyll.com/csaw2015/start)

![Start](step1.png)

Upon entering link we are greeted with just a few lines of text:

> CSAW 2015 FUZYLL RECON PART 1 OF ?: Oh, good, you can use HTTP! The next part is at /csaw2015/<the acronym for my university's hacking club>.

From here we can google "Alexander Taylor" After looking through some github pages, twitter, and possible facebook, I started thinking, where is a sure place for Mr. Taylor to have his school? !! **HIS LINKEDIN**

I found his [LinkedIn](https://www.linkedin.com/in/fuzyll) by using the same domain as his website (https://www.linkedin.com/in/fuzyll). We can assume this his online handle.

![LinkedinScreen](LinkedIn.png)

Upon checking his LinkedIn, we see he went to the University of South Florida.

```
Current:	Ratheon
Previous:	The Brand Book, Sypris Electronics, LLC, University of South Florida
Education: 	University of South Florida
```

Aftet which we can google "University of south florida hacking club" which brings us to:

[Whitehatters Computer Security Club](http://www.wcsc.usf.edu/)
![wcsc](wcsc.png)

On this page we can clearly see the acronym: wcsc

Moving onto [http://fuzyll.com/csaw2015/wcsc](http://fuzyll.com/csaw2015/wcsc) We are greeted with a similar string of hints.

	> CSAW 2015 FUZYLL RECON PART 2 OF ?: TmljZSB3b3JrISBUaGUgbmV4dCBwYXJ0IGlzIGF0IC9jc2F3MjAxNS88bXkgc3VwZXIgc21hc2ggYnJvdGhlcnMgbWFpbj4uCg==

This is obviously Base64 encoding so putting that into an online decoder such as [https://www.base64decode.org/](https://www.base64decode.org/) we get:

>Nice work! The next part is at /csaw2015/<my super smash brothers main>.

I googled "Fuzyll Smash" and arrived at a few [YouTube](https://www.youtube.com/watch?v=59QQ9UevSuE) Pages.

![youtube](youtube.png)

The answer here is from the title is Yoshi:

		> Smash 4 Weekly (2015-08-07) - Fuzyll (Yoshi) vs. Stiitch (Ike)


One step closer, we move on to the next page. [http://fuzyll.com/csaw2015/yoshi](http://fuzyll.com/csaw2015/yoshi) We see a picture of yoshi here. 
![Yoshi](yoshi.txt)

Noticing we have a picture, a good step would probably be to look at the metadeta. After downloading the picture, you can either upload it to [Jeffrey's Exif viewer](http://regex.info/exif.cgi) or run exiftool, a tool to look at metadeta for like everything.

> exiftool yoshi.txt (it was named yoshi.txt i guess to throw us off)

This gives us:
```
ExifTool Version Number         : 9.46
File Name                       : yoshi.txt
Directory                       : .
File Size                       : 198 kB
File Modification Date/Time     : 2015:09:19 12:52:48-07:00
File Access Date/Time           : 2015:09:20 13:25:40-07:00
File Inode Change Date/Time     : 2015:09:20 13:25:40-07:00
File Permissions                : rw-r-----
File Type                       : PNG
MIME Type                       : image/png
Image Width                     : 500
Image Height                    : 537
Bit Depth                       : 8
Color Type                      : RGB with Alpha
Compression                     : Deflate/Inflate
Filter                          : Adaptive
Interlace                       : Noninterlaced
Background Color                : 255 255 255
Pixels Per Unit X               : 2835
Pixels Per Unit Y               : 2835
Pixel Units                     : Meters
Modify Date                     : 2015:09:18 03:00:11
Comment                         : CSAW 2015 FUZYLL RECON PART 3 OF ?: Isn't Yoshi the best?! The next egg in your hunt can be found at /csaw2015/<the cryptosystem I had to break in my first defcon qualifier>.
Image Size                      : 500x537
```

Looking at the comment we need to find the cryptosystem he did in his first defcon.:

> Comment: CSAW 2015 FUZYLL RECON PART 3 OF ?: Isn't Yoshi the best?! The next egg in your hunt can be found at /csaw2015/<the cryptosystem I had to break in my first defcon qualifier>.

From here I googled every iteration with words like fuzyll, decon, qualifier, cryptography, writeups, cryptosystem, but nothing showed up.I then started to guess since they isn't that many to guess with.

>http://fuzyll.com/csaw2015/rsa
>http://fuzyll.com/csaw2015/enigma

Enigma somehow worked. Going on to [http://fuzyll.com/csaw2015/enigma](http://fuzyll.com/csaw2015/enigma). We are greeted with another text.

```
 CSAW 2015 FUZYLL RECON PART 4 OF 5: Okay, okay. This isn't Engima, but the next location was "encrypted" with the JavaScript below: Pla$ja|p$wpkt$kj$}kqv$uqawp$mw>$+gwes6451+pla}[waa[ia[vkhhmj
		
		var s = "THIS IS THE INPUT"
		var c = ""
		for (i = 0; i < s.length; i++) {
		    c += String.fromCharCode((s[i]).charCodeAt(0) ^ 0x4);
		}
		console.log(c);
```

Looks like he took some input and xor'd with the hex character '0x4'. If you guys know your cryptography you can xor with '0x4 again to get the original text'(Crpypto 101)

I modified the js to pretty much do the same exact thing, but with the string given.

javascript_decode.js
```javascript
var s = "Pla$ja|p$wpkt$kj$}kqv$uqawp$mw>$+gwes6451+pla}[waa[ia[vkhhmj"
var c = ""
for (i = 0; i < s.length; i++) 
{
	c += String.fromCharCode((s[i]).charCodeAt(0) ^ 0x4);
}
alert(c);
```

I put this code into [An online javascript interpreter](http://www.webtoolkitonline.com/javascript-tester.html) and was given the string

> The next stop on your quest is: /csaw2015/they_see_me_rollin

Finally, we arrive at the final page:	[http://fuzyll.com/csaw2015/they_see_me_rollin](http://fuzyll.com/csaw2015/they_see_me_rollin) with a string

> CSAW 2015 FUZYLL RECON PART 5 OF 5: Congratulations! Here's your flag{I_S3ARCH3D_HI6H_4ND_L0W_4ND_4LL_I_F0UND_W4S_TH1S_L0USY_FL4G}!

flag{I_S3ARCH3D_HI6H_4ND_L0W_4ND_4LL_I_F0UND_W4S_TH1S_L0USY_FL4G}!