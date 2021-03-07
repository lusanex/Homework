package edu.miracosta.cs113.DSClue;

/**
 * RandomClue.java : Your job is to ask your AssistantJack and get the correct
 * answer in <= 20 tries.  RandomClue is ONE solution to the problem,
 * where a set of random numbers is generated every attempt until all three
 * random numbers match the solution from the AssistantJack object.
 *
 * This is a sample solution, a driver using random number implementation.
 * You can use this file as a guide to create your own SEPARATE driver for
 * your implementation that can solve it in <= 20 times consistently.
 *
 * @author Nery Chapeton-Lamas (material from Kevin Lewis)
 * @version 1.0
 *
 */

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

import edu.miracosta.cs113.DSClue.model.Theory;
import edu.miracosta.cs113.DSClue.model.AssistantJack;

public class MySolution {

    //The algorithm of this program is explained on questions.md

    public static void main(String[] args) {

        int answerSet, solution, murder, weapon, location;

        Theory answer;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
        answerSet = keyboard.nextInt();
        keyboard.close();

        jack = new AssistantJack(answerSet);

	weapon = 1;
	murder =1;
	location =1;
        do {

            solution = jack.checkAnswer(weapon, location, murder);
	    if ( solution == 1 ){
		  weapon++;
	    }
	    else if ( solution == 2 ){

	        location++;

	    }
	    else if ( solution == 3  ){

	         murder++;

	    }


        } while (solution != 0);

        answer = new Theory(weapon, location, murder);

        // OUTPUT
        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);

        if (jack.getTimesAsked() > 20) {
            System.out.println("FAILED!! You're a horrible Detective...");
        } else {
            System.out.println("WOW! You might as well be called Batman!");
        }

    }



}
