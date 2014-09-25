// Anthony Langga 007747571 CS 47-02 Hw 1 d2h converts decimal to hexadecimal and h2d converts hexadicmal to decimal
long long int d2h(char* decimal)
{
	int i = 0, count, temp,sign = 0;
	long long int power = 1;
	long long int base10 = 0;
	long long int number;
	while (decimal[i] != '\0'){
		i++;
	}

	count = i;
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
		for (temp = 0; temp < count-1; temp++)
		{
			power = power* 10;
		}
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

long long int h2d(char* hexadecimal)
{
	int length = 0, count = 0;
	long long int answer = 0;
	int temp;
	long long int c;
	char cc;
	long long int power = 1;
	while (hexadecimal[length] != '\0')
	{
		length++;
	}
	count = length;
	if(hexadecimal[0] == '0')
	{
		if (hexadecimal[1] =='x')
		{
			count--;
			count--;
		}
	}
	while (count != 0)
	{
	for (temp = 0; temp < count-1  ; temp++)
	{
		power = power* 16;
	}
	cc = hexadecimal[length-count];
	if (cc >= 'A' && cc <= 'Z')
		{
			cc += 32;
		}
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

