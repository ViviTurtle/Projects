#Anthony Langga
#CS 47 Section 2
#Hw 3
#This takes divides two numbers and finds the quotient and the remainder
	.file	"big_divq.c"
	.text
	.globl	divq
	.type	divq, @function
divq:
.LFB0:
	movq	%rdi, %rax
	movq    %rdx, %r8
	movq	(%rcx), %rdx
	divq	%rsi #Divides RDX:RAX by RSI
	movq    %rdx, (%rcx)
	movq 	%r8, %rdx
	movq	%rax, (%rdx)
	ret
