#include <stdio.h>
#include "hw3.h"

lli binomialq(int n, int m);

int main(int argc, char* argv[]){
    int n, m;
    lli ans = 1;
    if(argc < 3) {printf("Usage: binomialq n m (integers: 0 <= m <= n)\n"); return -1;}
    sscanf(argv[1], "%d", &n);
    sscanf(argv[2], "%d", &m);
    if((n < 0)||(m < 0)||(m > n) )printf("%d or %d out of range\n", n, m);
    else{
        m = ((n-m) < m) ? (n-m) : m; // Use smaller of m, (n-m)
        ans = binomialq(n, m);
        printf("binomial(%d, %d) = %lld (%.16llx)\n", n, m, ans, ans);
    }
    return(0);
}