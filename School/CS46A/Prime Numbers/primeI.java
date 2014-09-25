/*
 * This class creates the first known set of prime number
s
/*
    This class writes out Prime numbers. A number is prime if it is 
    divisible by 1 and the number itself and no other number.
*/

public class primeI
{
  // This method tests whether a given number is prime or not.
  public static boolean isPrime ( int num )
  {
    boolean prime = true;
    int limit = (int) Math.sqrt ( num );  

    for ( int i = 2; i <= limit; i++ )
    {
      if ( num % i == 0 )
      {
        prime = false;
	break;
      }
    }

    return prime;
  }

  public static void main ( String[] args )
  {
    // This loop writes out all the prime numbers less than 1000.
    for ( int i = 2; i <= 1000; i++ )
    {
      if ( isPrime ( i ) )
	System.out.print ( i );
	System.out.print (" ");
    }
  }
}

