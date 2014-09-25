//By Anthony Langga
//CS 47 Section 2
//HW#2
//Builds a floating point numbers given the parts (integer, exponent, and fraction)
#include <stdio.h>
#include "hw2.h"

double ll2d(unsigned long long int l) 
//Convert 64-bit integer to double with same bit pattern 
 {
  union {
    double dd;
    unsigned long long int ll;
  }a;
  a.ll = l;
  return a.dd;
}

struct dbits parts2bits(struct dparts y1)
//Converts dparts into another struct dbits
{
	struct dbits db;
	if (y1.s == '-')
	{
		db.sbit = 1;
	}
	else
	{
		db.sbit = 0;
	}
	if (y1.d == 0) 
	{	
		db.e = 0; 
	}
	else
	{
		//1023 is the BIAS for doubles
		db.e = y1.E + 1023;
	}
	db.fbits = y1.f;
	return db;
}

unsigned long long int bits2lli(struct dbits db)
//Convrts the struct dbits into a long long int by bit masking
{
	unsigned long long int answer = 0;
	answer = answer | (unsigned long long int) db.sbit<<63; //MSB 
	answer = answer | (unsigned long long int) db.e<<52; 
	answer = answer | (unsigned long long int) db.fbits;
	return answer;

}
double builddbl(struct dparts dp)
{
	//checking for invalid inputs
	if (!(dp.s == '-' || dp.s == '+'))
	{
		return ll2d(NaN);
	}
	if (!(dp.E>=-1022 && dp.E<=1023))
	{
		return ll2d(NaN);
	} 
	if (!(dp.d == 0 || dp.d == 1))
	{
		return ll2d(NaN);
	}
	// bit masking with 0xFFFFFFFFFFFFFF in decimal form
	dp.f = dp.f & 4503599627370495; 
	double answer;
	struct dbits db;
	db = parts2bits(dp);
	return ll2d(bits2lli(db));
}
int main(int argc, char* argv[])
{
	struct dparts y1;
	double answer;
	unsigned long long int lli;
	sscanf(argv[1],"%c", &y1.s);
	sscanf(argv[2],"%i", &y1.E);
	sscanf(argv[3],"%i", &y1.d);
	sscanf(argv[4],"%llx", &y1.f);
	answer = builddbl(y1);
	printf("value = %.17g (%llx)\n", answer, bits2lli(parts2bits(y1)));
	return 0;
}

