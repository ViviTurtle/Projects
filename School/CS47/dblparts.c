//By Anthony Langga
//CS 47 Section 2
//HW#2
//Disassembles a floating point number into parts (integer, fraction, exponent)

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

struct dbits ll2bits(unsigned long long int x1)
//Converts a long long int x1 into a struct dbits by looking at the bits
{
	struct dbits db;
	unsigned long long int tempf = x1;
	unsigned long long int tempe = x1;
	if ((x1>>63) == 0)
	{
		db.sbit = 0;
	} 
	else
	{
		db.sbit = 1;
	}
	db.e = x1<<1>>53; //Takes off most sig bit and the first 52
	tempf = tempf<<12;
	tempf = tempf>>12;
	db.fbits = tempf;
	return db;
}

struct dparts bits2parts(struct dbits x2)
//Converts dbits into dparts
{
	struct dparts dp;
	if (x2.sbit == 1)
	{
		dp.s = '-';
	}
	else
	{	
	dp.s = '+';
	}
	if (x2.e == 0)
	{
		dp.d = 0;
		//1023 is the BIAS in doubles
		dp.E = 1-1023;
	}	
	else
	{
		dp.E = x2.e - 1023;
		dp.d = 1;
	}
	dp.f = x2.fbits;
	return dp;
}

struct dparts dblparts(double d)
{
	struct dbits db;
	struct dparts dp;
	db = ll2bits(d2ll(d));
	dp = bits2parts(db);
	return dp;
}
int main(int argc, char* argv[])
{
	int i;
	double d;
 	struct dparts dp;
	for (i = 1; i < argc; i++)
	{
		sscanf(argv[i], "%lf", &d);
		dp = dblparts(d);
		printf("sign = %c, E = %i intpart = %i fracpart = %.13llx\n",dp.s, dp.E, dp.d, dp.f);
	}
}
