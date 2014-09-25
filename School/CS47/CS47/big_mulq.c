/* test mulq routine               */
/* T. Howell CS 47                 */
#include <stdio.h>

typedef unsigned long long int ulli;

void mulq(ulli x, ulli y, ulli *pl, ulli *ph);  //for Unix/Mac
void mulqW(ulli x, ulli y, ulli *pl, ulli *ph); //for Windows

int main(int argc, char* argv[])
{
   ulli x, y, high, low;
   if(argc != 3) {printf("Usage: hex number hex number\n"); return(1);};
   sscanf(argv[1], "%llx", &x);
   sscanf(argv[2], "%llx", &y);
   //mulq(x, y, &high, &low);
   mulqW(x, y, &high, &low);
   printf("%16llx x %16llx = %.16llx %.16llx\n", x, y, high, low);
   return 0;
}



