#Anthony Langga
#CS 47 Section 2
#Hw 3
#This takes divides two numbers and finds the quotient and the remainder
	.file	"big_divq.c"
	.text
	.globl	divq
	.type	divq, @function
	
divq:			# args in rdi, rsi, rdx, rcx $/
	movq	%rdx, %r10		# save ptr to quotient 	 	 
	movq	(%rcx), %rdx	# xh to %rdx 	 	 
	movq	%rdi, %rax		# xl to %rax 	 	 
	divq	%rsi			# rdx:rax / rsi -> q = rax  rem = rdx 	 	 
	movq	%rax, (%r10)	#quotient  x/y 	 	 
	movq	%rdx, (%rcx)	#remainder x%y 	 	 
	ret
	
