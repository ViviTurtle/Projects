/*
Anthony Langga
CS 47 Homework 4 
Spring 2014
March 14, 2014

Disassemble Y86 code as in Practice Problem 4.2.
Produce assembly code from a string of machine code and a starting address.
A function next() takes a string and produces a structure describing the next instruction.
When called by disas, it helps produce output like this.

Example:  input: 0x100 30f0f8ffffff40010c06000000
output: 
0x100:	30f0f8ffffff		irmovl $-8, %eax
0x106:	40010c060000		rmmovl %eax, 0x60c(%ecx)
0x10c:	00					halt

*/
#include "hw4.h"

struct inst next(char *p){
/* 
p should point to a non-empty string of Y86 machine instructions
hex characters are in lower case
*/
	struct inst r = {0, 1, "       ", 0xf, 0xf, 0};		//default return value
	unsigned char oph1, oph2;
	oph1 = *p++;	//first hex character of operation code
	oph2 = *p++; 	//second hex character of operation code
	switch(oph1){
		case '0':
			if (oph2 != '0') {
				printf("error: illegal opcode %c%c\n", oph1, oph2);
				r.flag = -1;
			}
			else {
				r.opname = "halt";
			}
			break;
		case '1':
			if (oph2 != '0') {
				printf("error: illegal opcode %c%c\n", oph1, oph2);
				r.flag = -1;
			}
			else {
				r.opname = "nop";
			}
			break;
		case '2':
			switch(oph2) {
				case '0':
					r.opname = "rrmovl";
					break;
				case '1':
					r.opname = "cmovle";
					break;
				case '2':
					r.opname = "cmovl";
					break;
				case '3':
					r.opname = "cmove";
					break;
				case '4':
					r.opname = "cmovne";
					break;
				case '5':
					r.opname = "cmovge";
					break;
				case '6':
					r.opname = "cmovg";
					break;
				default: 
					printf("error: illegal opcode %c%c\n", oph1, oph2);
					r.flag = -1;
					break;
				}
			if (r.flag != -1)
			{
					r.len = 2;
					r.rA = c2h(*p++);
					r.rB = c2h(*p++);
			}
			break;
		case '3':
			if (oph2 != '0') {
				printf("error: illegal opcode %c%c\n", oph1, oph2);
				r.flag = -1;
			}
			else {
				r.len = 6;
				r.opname = "irmovl";
				r.rA = c2h(*p++);
				r.rB = c2h(*p++);
				//if (r.rA != c2h('f'));
				//{
				//r.flag = -1;
				//}
				r.D = gethex(p);
			}
			break;		
		case '4':
			if (oph2 != '0') {
				printf("error: illegal opcode %c%c\n", oph1, oph2);
				r.flag = -1;
			}
			else {
				r.len = 6;
				r.opname = "rmmovl";
				r.rA = c2h(*p++);
				r.rB = c2h(*p++);
				r.D = gethex(p);
			}
			break;
		case '5':
			if (oph2 != '0') {
				printf("error: illegal opcode %c%c\n", oph1, oph2);
				r.flag = -1;
			}
			else{
				r.len = 6;
				r.opname = "mrmovl";
				r.rA = c2h(*p++);
				r.rB = c2h(*p++);
				r.D = gethex(p);
			}
			break;
		case '6':
			switch(oph2) {
				case '0':
					r.opname = "addl";
					break;
				case '1':
					r.opname = "subl";
					break;
				case '2':
					r.opname = "andl";
					break;
				case '3':
					r.opname = "xorl";
					break;
				default: 
					printf("error: illegal opcode %c%c\n", oph1, oph2);
					r.flag = -1;
					break;
				}
			if (r.flag != -1) {
					r.len = 2;
					r.rA = c2h(*p++);
					r.rB = c2h(*p++);
			}
			break;
		case '7':
			switch(oph2) {
				case '0':
					r.opname = "jmp";
					break;
				case '1':
					r.opname = "jle";
					break;
				case '2':
					r.opname = "jl";
					break;
				case '3':
					r.opname = "je";
					break;
				case '4':
					r.opname = "jne";
					break;
				case '5':
					r.opname = "jge";
					break;
				case '6':
					r.opname = "jg";
					break;
				default: 
					printf("error: illegal opcode %c%c\n", oph1, oph2);
					r.flag = -1;
					break;
				}
			if (r.flag != -1)
			{
					r.len = 5;
					r.D = gethex(p);
			}
			break;
		case '8':
			if (oph2 != '0') {
				printf("error: illegal opcode %c%c\n", oph1, oph2);
				r.flag = -1;
			}
			else {
				r.len = 5;
				r.opname = "call";
				r.D = gethex(p);
			}
			break;
		case '9':
			if (oph2 != '0') {
				printf("error: illegal opcode %c%c\n", oph1, oph2);
				r.flag = -1;
			}
			else {
				r.opname = "ret";
			}
			break;
		case 'a':
			if (oph2 != '0') {
				printf("error: illegal opcode %c%c\n", oph1, oph2);
				r.flag = -1;
			}
			else {
				r.opname = "pushl";
				r.rA = c2h(*p++);
				r.rB = c2h(*p++);
				if (r.rB != c2h('f')) {
				r.flag = -1;
				}
				r.len = 2;
			}
			break;
		case 'b':
			if (oph2 != '0') {
				printf("error: illegal opcode %c%c\n", oph1, oph2);
				r.flag = -1;
			}
			else {
				r.opname = "popl";
				r.rA = c2h(*p++);
				r.rB = c2h(*p++);
				if (r.rB != c2h('f')) {
				r.flag = -1;
				}
				r.len = 2;
			}
			break;	
		default:
			printf("error: illegal opcode %c%c\n", oph1, oph2);
			r.flag = -1;
			break;
	}
	return r;
}

