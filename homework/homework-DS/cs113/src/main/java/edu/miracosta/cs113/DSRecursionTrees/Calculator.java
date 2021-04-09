
package edu.miracosta.cs113.DSRecursionTrees;

import java.util.*;

public class Calculator
{
    // instance variables - replace the example below with your own
    int numberOfPennys;
    int numberOfDimes;
    int numberOfNickles;
    int numberOfQuarters;

    /**
     * Constructor for objects of class Coin
     */
    public Calculator()
    {
        numberOfPennys = 0;
        numberOfDimes = 0;
        numberOfNickles = 0;
        numberOfQuarters = 0;
    }

    public Calculator(Calculator c)
    {
        this.numberOfPennys = c.numberOfPennys;
        this.numberOfDimes = c.numberOfDimes;
        this.numberOfNickles = c.numberOfNickles;
        this.numberOfQuarters = c.numberOfQuarters;
    }

    public void addPenny()
    {
        numberOfPennys = numberOfPennys +1;
    }

    public void addQuarter()
    {
        numberOfQuarters = numberOfQuarters +1;
    }

    public void addNickle()
    {
        numberOfNickles = numberOfNickles +1;
    }

    public void addDime()
    {
        numberOfDimes = numberOfDimes +1;
    }

    public String toString()
    {
        String s = "P D N Q\n";
        s += String.format(Integer.toString(numberOfPennys) +" "+  numberOfDimes+ " " +numberOfNickles + " "+ numberOfQuarters);
        return s;
    }

    public boolean equals(Object o)
    {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Calculator))
        {
            return false;
        }

        Calculator c = (Calculator) o;

        return Integer.compare(numberOfPennys, c.numberOfPennys) == 0
                && Integer.compare(numberOfDimes, c.numberOfDimes) == 0
                && Integer.compare(numberOfNickles, c.numberOfNickles) == 0
                && Integer.compare(numberOfQuarters, c.numberOfQuarters) == 0;
    }
}
