/*
	Anthony Langga CS47-02 007747571 (Note this is just a resubmission of an earlier A with my name on it)
	
	This application finds the value of C(n,m)
*/

#include <stdio.h>

typedef unsigned long long int ulli;
void mulq(ulli x, ulli y, ulli* high, ulli* low);
void divq(ulli dl, ulli dv, ulli* q, ulli* r);
int length;
ulli answer[160];
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
	ulli temp1 = 0;
	ulli temp2 = 0;	
	ulli *h = &temp1; 
	ulli *l = &temp2;
	int k;
	for (k = length -1; k >= 0; k--)
	{
			mulq(answer[k], multi, h, l);
			answer[k] = *l + rem;
			rem = *h;
	}
	if (rem != 0)
	{
		slide();
		answer[0] = rem;
		rem = 0;
	}	
}

void divi(ulli star)
{
	int l;
	ulli temp = 0;
	ulli temp2 = 0;
	ulli* quo = &temp;
	ulli* highs = &temp2;
	for (l = 0; l < length ; l++)
	{
		divq(answer[l], star, quo, highs);
		answer[l] =  *quo;
	}
	if (answer[0] == 0)
	{
		slide_down();
		answer[length] = 0;
	}


}
ulli binomialk(int n, int m, int k )
{
	length = 1;
	ulli tempo[160] = {0};
	if (n > 10150)
	{		
		return -1;
	}
	ulli dif,  star;
	answer[0] = n;
	dif = n- m;
	if (dif > m)
	{
		dif = m;
	}	
	for (star = 1; star < dif; star++)
	{
		mult(n - star);
		divi(star+1);
	}
	return answer[length-k-1];
}
/*int main(int argc, char* argv[])
{
	ulli n, m, k;
	sscanf(argv[1], "%lli", &n);
	sscanf(argv[2], "%lli", &m);
	sscanf(argv[3], "%lli", &k);
	printf("%llx\n" ,binomialk(n, m, k));
	return 0;
}*/
