struct dparts {
	char s;
	int E;
	int d;
	unsigned long long int f;
};

struct dbits {
	int sbit;
	int e;
	unsigned long long int fbits;
};

#define NaN	0x7fffffffffffffffLL

double ll2d(unsigned long long int l);
/* convert long long integer to double with same bit pattern */

unsigned long long int d2ll(double d);
/* convert double to long long integer with same bit pattern */

double builddbl(struct dparts p);
struct dparts dblparts(double val);
struct dbits parts2bits(struct dparts p);
struct dparts bits2parts(struct dbits);
