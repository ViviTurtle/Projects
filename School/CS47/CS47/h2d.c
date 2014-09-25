///Anthony Langga CS47-02 Hw1 This program allows the conversion between hex into decimal
#include <stdio.h>

/*
 * Converts a hex string to a long long int
 * @param hexadecimal the string to convert
 * @returns the long long int converted from hexadecimal
 */
long long int c2h(char* hexadecimal)
{
	int length = 0, count = 0;
	long long int answer = 0;
	int temp;
	long long int c;
	char cc;
	long long int power = 1;
	//Gets the length of the string
	while (hexadecimal[length] != '\0')
	{
		length++;
	}
	count = length;
	//if the string begins with 0x (indicating its a hexadecimal) its ok
	if(hexadecimal[0] == '0')
	{
		if (hexadecimal[1] =='x')
		{
			//reduces count by 2 so it skips the first two chars when converting
			count--;
			count--;
		}
	}
	while (count != 0)
	{
	// Powers of 16 for each char
	for (temp = 0; temp < count-1  ; temp++)
	{
		power = power* 16;
	}
	cc = hexadecimal[length-count];
	//conversion to lower case and into a digit
	if (cc >= 'A' && cc <= 'Z')
		{
			cc += 32;
		}
		//making the int 10 - 16 if its A-F
		switch (cc)
		{
		case 'a':
			c = 10;
			break;
		case 'b':
			c = 11;
			break;
		case 'c':
			c = 12;
			break;
		case 'd':
			c = 13;
			break;
		case 'e':
			c = 14;
			break;
		case 'f':
			c = 15;
			break;

		default: c = cc - '0';
		}
	if (c >= 0 && c <= 16)
	{
	answer += (c * power);
	power = 1;
	count--;
	}
	else exit(0);
	}
	return answer;
}
/*
 * For each command line hex argument converts it to decimal
 * @param argv[] the list of arguments to convert
 * @Prints the decimal conversion
 */
int main(int argc, char* argv[])
{
	int i;
	for (i = 1; i < argc; i++)
	{
		printf("%lli\n",c2h(argv[i]));
	}
	return 0;
}



