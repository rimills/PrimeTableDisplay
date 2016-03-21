import java.io.*;
/**
 * Class to take in integer input and create a multiplication table of the first n primes, where n is that integer input
 * 
 * @author Ross Mills 
 * @version 1.1
 */
public class Calculator
{
    

    /**
     * Constructor for objects of class Calculator
     */
    public Calculator()
    {
       
    }

    public static void main(String[] args)
    /**
     * Main method for the program, which starts the program by asking for the user's input.
     * 
     * @param Nothing
     * @return Nothing
     */
    {
        String input;
        int intInput = 0;
        
        
        InputStreamReader inputstream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputstream);
          

        System.out.println("Which number prime is the maximum you wish to use?");
        try {
        input = reader.readLine();
        intInput = Integer.parseInt(input);
       }
       catch (IOException e)
       {
           System.out.println("Reading Failure");
        }
        
       int[] setOfPrimes = new int[intInput];
        
       for (int counter = 0; counter < intInput; counter++)
       {
           setOfPrimes[counter] = nthPrime(counter+1);
       }
       
       System.out.print("/t");
       for (int counter = 0; counter < intInput; counter++)
       {
           System.out.print(setOfPrimes[counter] + "/t");
        }
    }
    
    public static int nthPrime(int n) {
     int candidate, count;
    
     for(candidate = 2, count = 0; count < n; ++candidate) {
        if (isPrime(candidate)) {
            ++count;
        }
     }
     // The candidate has been incremented once after the count reached n, so we need to take away one to get the nth Prime
     return candidate-1;
   }
    private static boolean isPrime(int n) {
        if (n % 2 == 0) {
            return n == 2;
        }
        if (n % 3 == 0) {
            return n == 3;
        }
        int step = 4;
        int counter = (int)Math.sqrt(n) + 1;
        for(int i = 5; i < counter; step = 6-step, i += step) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;

    }
}
