/*
Header file for CS 47 HW 4 March 25, 2013  T. Howell
*/
#include <stdio.h>

struct inst {
	int flag;			//Boolean: success = 0, failure = -1
	int len;			//length in bytes
	char *opname;		//pointer to Y86 instruction name (e.g. "rrmovl")
	char rA;			//this is a hex digit (2), not a character ('2').
	char rB;
	int D;				//immediate value, address displacement, or jump destination
};

extern char *jumps[]; // = {"jmp", "jle", "jl", "je", "jne", "jge", "jg"};
extern char *cmoves[]; // = {"rrmovl", "cmovle", "cmovl", "cmove", "cmovne", "cmovge", "cmovg"};
extern char *regs[]; // = {"%eax", "%ecx", "%edx", "%ebx", "%esp", "%ebp", "%esi", "%edi"};
extern char *ops[]; // = {"addl", "subl", "andl", "xorl"};

int c2h(char p);
int s2b(char *p);
int gethex(char *p);