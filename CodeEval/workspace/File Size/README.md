File Size (**Solved**)
------------------------
https://www.codeeval.com/open_challenges/26/

**Challenge Description:**

>Print the size of a file in bytes.

**Input:**

The first argument to your program has the path to the file you need to check the size of.

**Output sample:**

Print the size of the file in bytes. E.g.

>55

Size.py
```python
import sys
import os
#Stores file data into variable reader
reader = os.stat(sys.argv[1])
#Prints file size
print reader.st_size
```
