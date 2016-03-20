
/**
 * Write a description of class Calculator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Calculator
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Calculator
     */
    public Calculator()
    {
       
    }

    public static void main()
    {
        //
        
    }
    
    public static int nthPrime(int n) {
     int candidate, count;
    
     for(candidate = 2, count = 0; count < n; ++candidate) {
        if (isPrime(candidate)) {
            ++count;
        }
     }
     // The candidate has been incremented once after the count reached n
     return candidate-1;
   }
    private static boolean isPrime(int n) {
        if (n % 2 == 0) return n == 2;
        if (n % 3 == 0) return n == 3;
        int step = 4, m = (int)Math.sqrt(n) + 1;
        for(int i = 5; i < m; step = 6-step, i += step) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;

    }
}
