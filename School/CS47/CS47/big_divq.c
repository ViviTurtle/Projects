/* test divq function */
/* Anthony. Langga CS 47 Section 2 */

#include <stdio.h>
#include "hw3.h"

void divq(ulli x1, ulli y, ulli *q, ulli *r);

int main(int argc, char* argv[])
{
	ulli xh, x1, y, q, rem;
	if (argc != 4) 
	{
		printf("Usage: hex number (xh) hex number(x1) hex number(y) \n");
		return 1;
	}
	sscanf(argv[1], "%llx", &xh);
	sscanf(argv[2], "%llx", &x1);
	sscanf(argv[3], "%llx", &y);
	rem = xh;
	divq(x1, y, &q, &rem);
	printf("%16llx : %16llx / %llx = \n%.16llx r. %.16llx\n", xh, x1, y, q, rem);
	return 0;
}
