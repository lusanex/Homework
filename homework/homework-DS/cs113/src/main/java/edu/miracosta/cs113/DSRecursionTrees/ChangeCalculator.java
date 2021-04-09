package edu.miracosta.cs113.DSRecursionTrees;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.File;
/**
 * ChangeCalculator : Class containing the recursive method calculateChange, which determines and prints all
 * possible coin combinations representing a given monetary value in cents.
 *
 * Problem derived from Koffman & Wolfgang's Data Structures: Abstraction and Design Using Java (2nd ed.):
 * Ch. 5, Programming Project #7, pg. 291.
 *
 * An additional method, printCombinationsToFile(int), has been added for the equivalent tester file to verify
 * that all given coin combinations are unique.
 */
public class ChangeCalculator
{

    static ArrayList<Calculator> listToAddToCoins = new ArrayList<Calculator>();
    /**
     * Wrapper method for determining all possible unique combinations of quarters, dimes, nickels, and pennies that
     * equal the given monetary value in cents.
     *
     * In addition to returning the number of unique combinations, this method will print out each combination to the
     * console. The format of naming each combination is up to the user, as long as they adhere to the expectation
     * that the coins are listed in descending order of their value (quarters, dimes, nickels, then pennies). Examples
     * include "1Q 2D 3N 4P", and "[1, 2, 3, 4]".
     *
     * @param cents a monetary value in cents
     * @return the total number of unique combinations of coins of which the given value is comprised
     */
    public static int calculateChange(int cents)
    {
        return calculateChange(cents,0, new Calculator());
    }
    public static int calculateChange(int cents, int count, Calculator coin)
    {
	//Base case
        if(cents == 0)
        {
            if(listToAddToCoins.contains(coin))
            {
                return 0;
            }
            else
            {
                listToAddToCoins.add(coin);
                return 1;
            }
        }
        
	    //Possible combinations.

            int numberToReturn = 0;
            if(cents >=1)
            {
                int tmpValueForPenny = (cents-1);
                Calculator tmpCalculator = new Calculator(coin);
                tmpCalculator.addPenny();
                numberToReturn = numberToReturn + calculateChange(tmpValueForPenny, 1, tmpCalculator);
            }
            if(cents%5 == 0 && cents >= 5)
            {
                int newValue = cents-5;
                Calculator tmpCalculator2 =  new Calculator(coin);
                tmpCalculator2.addNickle();
                numberToReturn = numberToReturn + calculateChange(newValue, 1, tmpCalculator2);
            }
            if(cents%10 == 0 && cents >= 10)
            {
                int newValue = cents-10;
                Calculator tmpCalculator2 =  new Calculator(coin);
                tmpCalculator2.addDime();
                numberToReturn = numberToReturn+ calculateChange(newValue, 1, tmpCalculator2);
            }
            if(cents%25 == 0 && cents >= 25)
            {
                int newValue = cents-25;
                Calculator tmpCalculator2 = new Calculator(coin);
                tmpCalculator2.addQuarter();
                numberToReturn = numberToReturn+ calculateChange(newValue, 1, tmpCalculator2);
            }
            count = numberToReturn;

        return count;
    }

    /**
     * Calls upon calculateChange(int) to calculate and print all possible unique combinations of quarters, dimes,
     * nickels, and pennies that equal the given value in cents.
     *
     * Similar to calculateChange's function in printing each combination to the console, this method will also
     * produce a text file named "CoinCombinations.txt", writing each combination on their own separate lines.
     *
     * @param cents a monetary value in cents
     */
    public static void printCombinationsToFile(int cents)
    {
        calculateChange(cents);
        String fileName = "CoinCombinations.txt";
        try
        {
            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(file);

            for (Calculator str : listToAddToCoins)
             {
                 fileWriter.write(str.toString());
             }
                fileWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

} // End of class ChangeCalculator
