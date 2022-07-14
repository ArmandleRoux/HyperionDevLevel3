public class PrimeNumberMethod {

  /* Test if number is a Prime number ny checking if
  *  it can be fully divided by a number other than
  *  1 and itself. */
  public boolean isPrime(int number) {
    if(number > 1) {
      for (int i = 2; i < number; i++) {
        if (number % i == 0) {
          return false;
        }
      }
    }
    return true;
  }


}
