/*
T. Howell
CS 47 Homework 4 
Spring 2014
March 19, 2014

Disassemble Y86 code as in Practice Problem 4.2.
Produce assembly code from a string of machine code and a starting address.
A function next() takes a string and produces a structure describing the next instruction.

Example:  input: 0x100 30f0f8ffffff40010c06000000
output: 
0x100:	30f0f8ffffff		irmovl $-8, %eax
0x106:	40010c060000		rmmovl %eax, 0x60c(%ecx)
0x10c:	00					halt

*/
#include <stdio.h>
#include <string.h>
#include <ctype.h>

char *jumps[] = {"jmp", "jle", "jl", "je", "jne", "jge", "jg"};
char *cmoves[] = {"rrmovl", "cmovle", "cmovl", "cmove", "cmovne", "cmovge", "cmovg"};
char *regs[] = {"%eax", "%ecx", "%edx", "%ebx", "%esp", "%ebp", "%esi", "%eadi"};
char *ops[] = {"addl", "subl", "andl", "xorl"};

int c2h(char p){
/* convert one character to its hex value */
	return (p <= '9') ? p -'0' : p - 'a' + 10;
}

int s2b(char *p){
/* read two hex characters and return a byte-size integer */
	char ph, pl;
	ph = *p;
	pl = *(p+1);
	return (c2h(ph) << 4) + c2h(pl);
}

int gethex(char *p){
/* read a 4-byte little endian hex number from string p */
	int i, h = 0;
	for (i=3; i >= 0; i--){
		h = (h << 8) + s2b(p+2*i);			//s2b takes "a3" and returns 163, for example
	}
	return h;
}

//The following line copies in the student's code for function next( ).
#include "hw4.c"

void printtherest(struct inst n){
/* print the remainder of the line (after opcode) */
	if (n.len == 1){			//halt, nop, ret
		printf("\n");
	}
	if (n.len == 2){			//rrmovl, OPl, comvXX, pushl, popl
		if (n.rA != 0xf) printf(" %s", regs[n.rA]);
		else {
			printf("\nerror: illegal register code %x\n", n.rA);
			return;
		}
		if (n.rB != 0xf) printf(", %s", regs[n.rB]);
		printf("\n");
	}
	if (n.len == 5){			//jxx, call
		printf(" 0x%.8x\n", n.D);
	}
	if (n.len == 6){
		if (n.rA == 0xf){		//irmovl
			printf(" $%d,%s\n", n.D, regs[n.rB]);
		}
		if (n.opname[0] == 'r'){//rmmovl
			printf(" %s, 0x%x(%s)\n", regs[n.rA], n.D, regs[n.rB]);
		}
		if (n.opname[0] == 'm'){//mrmovl
			printf(" 0x%x(%s), %s\n", n.D, regs[n.rB], regs[n.rA]);
		}
	}
	return;
}

int main(int argc, char *argv[]){
	struct inst n;
	int pc;
	char oneinst[16];				//buffer for one instruction
	char *cursor;					//points to next character to process 
	if (argc != 3) {
		printf("Usage: start address and one string of Y86 machine code\n");
		return -1;
	}
	sscanf(argv[1], "%x", &pc);		//starting address
	cursor = argv[2];
	while (*cursor) {
			*cursor = tolower(*cursor);		//convert to lower case
			cursor++;
		}
	cursor = argv[2];				//reset to beginning of input string
	
	while (*cursor) {
		n = next(cursor);
		oneinst[0] = '\0';			//make it an empty string
		strncat(oneinst, cursor, n.len<<1);
		strncat(oneinst, "              ", 12-(n.len<<1));	//make output look good
		cursor += n.len << 1;		//next call will start here
		printf("0x%.4x:\t%12s\t%s\t", pc, oneinst, n.opname);
		printtherest(n);
		pc += n.len;
	}
	return 0;
}
