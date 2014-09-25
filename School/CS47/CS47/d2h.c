//Anthony Langga CS47-02 Hw1 This program allows the conversion between decimal into hex

#include <stdio.h>

/*
 * Given a character array, we convert it to a long long int
 * @param decimal the character array to convert
 * @return the character array in decimal form
 */
long long int c2d(char* decimal)
{
	int i = 0, count, temp,sign = 0;
	long long int power = 1;
	long long int base10 = 0;
	long long int number;
	// Counts the length
	while (decimal[i] != '\0'){
		i++;
	}
	count = i;
	//Allows positive and negative integers
	if (decimal[0] == '-' || decimal[0] == '+')
	{
		if (decimal[0] == '-')
		{
			sign = 1;
		}
		count--;
	}
	while (count != 0 )
	{
		//10 to the power to manage placeholders for each digit
		for (temp = 0; temp < count-1; temp++)
		{
			power = power* 10;
		}
		//conversion from a char to an int
		number = (decimal[i-count]- '0');
		if (number >= 0 && number <= 9)
		{
		base10 += (number * power);
		count--;
		power = 1;
		}
		else exit(0);

	}
	if (sign == 1)
	{
		base10 *= -1;
	}
	return base10;
}
/*
 * Takes each command argument (in decimal) and converts it to hex otherwise it stops the program
 * @param argv[] the different arguments to convert
 * @Prints the hex form of each
 */
int main(int argc, char* argv[]) {
	int i, answer;
	for (i = 1; i < argc; i++)
	{
		answer = c2d(argv[i]);
		printf("%llx\n", answer); //prints long long int in hex form
	}
	return 0;
}
