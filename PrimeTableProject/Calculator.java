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

    /**
     * Main method for the program, which starts the program by asking for the user's input.
     * @param none
     * @return nothing
     */
    public static void main(String[] args)
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
       
       System.out.printf("%1$10s", "|");
       for (int counter = 0; counter < intInput; counter++)
       {
           System.out.printf("%1$10s", setOfPrimes[counter] + "|");
       }
       System.out.print("\n");
       for (int outerCounter = 0; outerCounter < intInput; outerCounter++)
       {
           System.out.printf("%1$10s", setOfPrimes[outerCounter] + "|");
           for (int innerCounter = 0; innerCounter < intInput; innerCounter++)
           {
               System.out.printf("%1$10s",setOfPrimes[outerCounter] * setOfPrimes[innerCounter] + "|");
           }
           System.out.print("\n");
        }
       
      
    }
    
    /**
     * Method for obtaining the nth prime number
     * @param Integer n
     * @return the nth prime number
     */
    public static int nthPrime(int n) {
     int candidate, count; //Instantiation of local variables
    
     for(candidate = 2, count = 0; count < n; ++candidate) { //For each number from 2 up until the correct number of primes have been found
        if (isPrime(candidate)) { 
            ++count; //If the currently checked number is a prime, increase the number of primes traversed by 1
        }
     }
     // The candidate has been incremented once after the count reached n, so we need to take away one to get the nth Prime
     return candidate-1;
   }
    /**
     * Method for checking if a number is prime
     * @param Integer the number to be checked
     * @return True or False, depending of whether or not the number is a prime
     */
    public static boolean isPrime(int n) {
        
        if (n % 2 == 0) {
            return n == 2; //If n is divisible by 2, then it is prime only if n is 2
        }
        if (n % 3 == 0) {
            return n == 3; //If n is divisible by 3, then it is prime only if n is 3
        }
        int step = 4;
        int counter = (int)Math.sqrt(n) + 1; //The maximum number that needs to be checked is the square root of the candidate + 1
        for(int i = 5; i < counter; step = 6-step, i += step) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;

    }
}
