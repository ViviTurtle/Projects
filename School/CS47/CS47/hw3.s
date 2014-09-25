#Anthony Langga
#CS 47 Seciton 2
#Hw3
#This finds the coeffecient of a number C(N,M) such that it finds the numbero f ways M and be made from N

	.file	"hw3.s"
	.text
	.globl	divq
	.type	divq, @function
	.globl  binomialq
	.type   binomialq, @function
    

divq:
.LFB0:
	
		
	
	movq	%rdi, %rax
	movq    %rdx, %r8
	movq	(%rcx), %rdx
	divq	%rsi
	movq    %rdx, (%rcx)
	movq 	%r8, %rdx
	movq	%rax, (%rdx)
	ret



	
	
	
binomialq:

	movq	$1,	%rax #N = 10
	movq 	$0 , 	%r8  #1-#
	movq	%rdi, 	%r9  #10-#
	incq	%r9
	cmpq	%r8,	%rsi
	jne	.Loop
	ret

.Loop:
	movq	$0, %rdx
	decq	%r9 
	mulq	%r9
	movq	$0 , %rdx
	incq 	%r8
	divq	%r8 
	cmpq	%r8,%rsi
	jne	.Loop
	ret
	



