#include <stdio.h>
#include <uniatd.h>

void doit()
{
	if (fork() == 0) 
	{
		printf("b1\n");
		fork();
		wait(NULL);
		printf("b2\n");
		exit(0);
	}
	return 0;
}

int main()
{
	printf("a\n");
	doit();
	wait(NULL); 
	printf("c\n");
	return 0;
}
