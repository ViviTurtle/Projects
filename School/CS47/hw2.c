//By Anthony Langga
//CS 47 Section 2
//HW#2
//Builds a floating point numbers given the parts (integer, exponent, and fraction) and vice versa
#include <stdio.h>
#include "hw2.h"

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
