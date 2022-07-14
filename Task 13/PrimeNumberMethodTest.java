import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumberMethodTest {

  @Test
  void testIsPrime() {

    int number = 29;
    PrimeNumberMethod primeNumberMethod = new PrimeNumberMethod();
    assertTrue(primeNumberMethod.isPrime(number));

    number = 15;
    assertFalse(primeNumberMethod.isPrime(number));

    number = 47;
    assertTrue(primeNumberMethod.isPrime(number) == isPrime(number));
  }

  public static boolean isPrime(int number) {
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