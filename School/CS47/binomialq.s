#Anthony Langga
#CS 47 Seciton 2
#Hw3
#This finds the coeffecient of a number C(N,M) such that it finds the numbero f ways M and be made from N
	.file	"binomialq.c"
	.text
	.globl	binomialq
	.type	binomialq, @function
binomialq:
.Main
		#rdi = N
		#rsi = M
		#r8 = 0-M
		#rcx = temp
	movq	$1,	%rax #RAX = 1
	movq 	$0 , 	%r8  #r8 = 0
	movq	%rdi, 	%r9  #r9 = N
	incq	%r9 	     #r9++
	cmpq	%r8,	%rsi 
	jne	.Loop   #for (r8 = 0; r8 < M; r8++)
	ret

.Loop:
	movq	$0, %rdx   #Zeros RDX
	decq	%r9  
	mulq	%r9
	movq	$0 , %rdx
	incq 	%r8
	divq	%r8 
	cmpq	%r8,%rsi  #For (r8; 48 < M; r8++)
	jne	.Loop
	ret
	
