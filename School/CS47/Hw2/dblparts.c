#include <stdio.h>
#include "hw2.h"

unsigned long long int d2ll(double d)
/* convert double to 64-bit integer with same bit pattern */
 {
  union {
    double dd;
    unsigned long long int ll;
  } a;
  a.dd = d;
  return a.ll;
}

struct dbits ll2bits(long long int x1)
{

}

struct dparts bits2parts(struct dbits x2)
{

}

void print_parts(char* number)
{

}
int main(int argc, char* argv[])
{
	int i;
	double d;
	for (i = 1; i < argc; i++)
	{
		d = sscanf(argv[i],"%.17g");
		printf("%d", d);
	}
}
