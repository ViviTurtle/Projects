#include <stdio.h>
main()
{
printf("Parent: Process started\n");
printf("Parent: Forking a child.\n");
if (fork() != 0) {
// Parent
int status;
printf("Parent: Wait for child to complete.\n");
waitpid(-1, &status, 0);
printf("Parent: Terminating.\n");
}
else {
// Child
printf("Child: Process started.\n");
printf("Child: Start 10 second idle:");
int i;
for (i = 10; i >= 0; i--) {
printf("%3d", i); fflush(stdout);
sleep(1);
}
printf(" done!\n");
printf("Child: Terminating.\n");
}
}
