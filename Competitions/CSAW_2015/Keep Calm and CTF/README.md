Keep Calm and CTF: Forensics 100
---------


>My friend sends me pictures before every ctf. He told me this one was special.

>Note: this flag doesn't follow the "flag{}" format

>[img.jpg](img.jpg)

This one had a super easy solution. First it gave us a jpg. First thing I always do is run strings

>strings img.jpg | grep flag

Nothing popped up.

Next thing you always do for any kind of picture, well any forensics for that matter is look at metadeta. Simply upload the data to [Jeffrey's Exif viewer](http://regex.info/exif.cgi) or we can also use a some tools we gathered over the preperation such as "exiftool", a tool to look at metadeta for everything.

>exiftool img.jpg

which gives me 

```
ExifTool Version Number         : 9.46
File Name                       : img.jpg
Directory                       : .
File Size                       : 92 kB
File Modification Date/Time     : 2015:09:18 15:52:29-07:00
File Access Date/Time           : 2015:09:20 13:25:40-07:00
File Inode Change Date/Time     : 2015:09:20 13:25:40-07:00
File Permissions                : rw-------
File Type                       : JPEG
MIME Type                       : image/jpeg
JFIF Version                    : 1.01
X Resolution                    : 72
Y Resolution                    : 72
Exif Byte Order                 : Big-endian (Motorola, MM)
Resolution Unit                 : inches
Y Cb Cr Positioning             : Centered
Copyright                       : h1d1ng_in_4lm0st_pla1n_sigh7
Image Width                     : 600
Image Height                    : 700
Encoding Process                : Baseline DCT, Huffman coding
Bits Per Sample                 : 8
Color Components                : 3
Y Cb Cr Sub Sampling            : YCbCr4:2:0 (2 2)
Image Size                      : 600x700
```

Looking at the copyright section
>Copyright                       : h1d1ng_in_4lm0st_pla1n_sigh7

you get the flag.

h1d1ng_in_4lm0st_pla1n_sigh7
