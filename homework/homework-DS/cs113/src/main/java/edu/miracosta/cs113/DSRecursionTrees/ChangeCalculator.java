package edu.miracosta.cs113.DSRecursionTrees;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ChangeCalculator {

static int[] coinValues = {25, 10, 5, 1};

static ArrayList<Integer> c;

private static ArrayList<String> combos = new ArrayList<String>();



public static int calculateChange(int cents) {

	c = new ArrayList<Integer>();


	for (int i = 0; i < cents + 1; i++){
		c.add(0);
	}

	c.set(0, 1); 

	for (int i = 0; i < coinValues.length; i++) {
		
		for (int j = 0; j < cents + 1; j++) {
			if (coinValues[i] <= j) 
				c.set(j, c.get(j) + c.get(j - coinValues[i])); 
		}
	}

	makeChange(cents, 0, 0, 0, cents); 

	for(String string : combos) { 
		System.out.println(string);
	}

	return c.get(cents);

}


	private static void makeChange(int total, int numQuarter, int numDime, int numNickel, int numPenny) {

		final int QUARTER = coinValues[0], DIME = coinValues[1], NICKEL = coinValues[2], PENNY = coinValues[3];

		if (numQuarter * QUARTER + numDime * DIME + numNickel * NICKEL + numPenny * PENNY > total) {
			return;
		}


		String s = "[" + numQuarter + ", " + numDime + ", " + numNickel + ", "+ numPenny + "]";

		if (!combos.contains(s))
			combos.add(s);



		if (numPenny >= 5)
			makeChange(total, numQuarter, numDime, numNickel + 1, numPenny - 5);
		if (numPenny >= 10)
			makeChange(total, numQuarter, numDime + 1, numNickel, numPenny - 10);
		if (numPenny >= 25)
			makeChange(total, numQuarter + 1, numDime, numNickel, numPenny - 25);
	}


	public static void printCombinationsToFile(int cents) {

		calculateChange(cents);

		try {
			File file = new File(ClassLoader.getSystemResource("CoinCombinations.txt").getFile());
			PrintWriter pw = new PrintWriter(new FileWriter(file));
			for (String combination : combos) {
				pw.println(combination);
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

} // End of class ChangeCalculator