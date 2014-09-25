#include <stdio.h>
#include "hw2.h"

double ll2d(unsigned long long int l) //
/* convert 64-bit integer to double with same bit pattern */
 {
  union {
    double dd;
    unsigned long long int ll;
  } a;
  a.ll = l;
  return a.dd;
}

struct dbits parts2bits(struct dparts y1)
{

}

long long int ll2d(struct dbits y3)
{

}

