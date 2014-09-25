#include <stdio.h>

typedef unsigned long long int ulli;
void mulq(ulli x, ulli y, ulli* high, ulli* low);
void divq(ulli dl, ulli dv, ulli* q, ulli* r);
ulli answer[160];
ulli den;
int length = 1;

void slide()
{ 	
	int z;
	for (z = length; z > 0; z--)
	{
		answer[z] = answer[z-1];
	}	
	length++;
	answer[0] = 0;
}
void slide_down()
{
	int i;
	for (i = 0; i < length; i++)
	{
		answer[i] = answer[i+1];
	}
	length--;

}
void mult(ulli multi)
{
	ulli rem = 0;
	ulli temp = 0;
	ulli *h = &rem; 
	ulli *l = &temp;
	int k;
	for (k = 0; k <= length; k++)
	{
			mulq(answer[k], multi, h, l);
			if ((answer[k] == 0) && (rem != 0))
			{
				length++;
			}
			answer[k] = *l + rem;
			rem = *h;
	}
}

void divi(ulli star)
{
	int l;
	ulli temp = 0;
	ulli temp2 = 0;
	ulli* quo = &temp;
	ulli* highs = &temp2;
	for (l = length-1; l >= 0 ; l--)
	{
		divq(answer[l], star, quo, highs);
		answer[l] =  *quo;
	}
	if (answer[length-1] == 0)
	{
		length--;
	}


}
ulli binomialk(int n, int m, int k)
{
	ulli dif, star;
	answer[0] = n;
	dif = n - m;
	for (star = 1; star < dif; star++)
	{
		mult(n - star);
		divi(star+1);
	}
	return answer[k];
}
