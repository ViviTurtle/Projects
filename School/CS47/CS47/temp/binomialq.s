	.file	"binomialq.c"
	.text
	.globl	binomialq
	.type	binomialq, @function
binomialq:
.Main:
	.cfi_startproc
	movq	$1, %rcx #temp
		#mulq S RAX by S Stored in RDX:RAX
                #divq S RDX:RAX by S Q = RAX R = RDX
		# add S, D
		# sub S , D
		#rdi = N
		#rsi = M
		#r8 = 0-M
		#rcx = temp
	movq 	$1, %r8
	add	$1, %rsi
		
.Loop:
	#for (int m = 1; m <= M; m++)
	movq	$0, %rdx
	movq	%rdi, %r9 #N = tempN
	dec	%r8       #tmpM--
	sub 	%r8,%r9   #tmpN - tmpM = tmpN
	movq 	%r9, %rax #tmpN = RAX
	incq	%r8       #tmpM++
	divq 	%r8       #RAX / tmpM = RAX
	mulq 	%rcx      #RAX * Tempbefore = RAX
	movq	%rax, %rcx#temp = Rax
	incq	%r8       #tmpM++
	cmpq 	%r8, %rsi # if (tmpM <= M) 
	jne	.Loop     # { do Loop} 
	ret
	.cfi_endproc
.LFE0:
	.size	binomialq, .-binomialq
	.ident	"GCC: (Ubuntu/Linaro 4.8.1-10ubuntu8) 4.8.1"
	.section	.note.GNU-stack,"",@progbits
