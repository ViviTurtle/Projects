#Anthony Langga
#CS 47 Section 2
#Hw 3
#This takes divides two numbers and finds the quotient and the remainder
	.file	"bigbinomial.c"
	.text
	.globl	mulq
	.type	mulq, @function

mulq:			# args in rdi, rsi, rdx, rcx
	movq  	%rdi, %rax		# x to %rax	 	 	 
	movq	%rdx, %r8		# save low pointer 	 	 
	mulq	%rsi			# rdx:rax <- rax * rsi 	 	  	 	 
	movq	%rax, (%rcx)	#low 	 	 
	movq  	%rdx, (%r8)		#high 	 	 
	ret
