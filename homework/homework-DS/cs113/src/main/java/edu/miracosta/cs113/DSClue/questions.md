## Random solution problems

The total permutations of the set (n,m,p) are given by the next formula n x m x p = nmp 
That means there are nmp different combinations for the set of three numbers. 
The random solution gives us two possible scenarios.
1. The first worst-case scenario the while loop will iterate nmp times to get the right answer.
2. The second case is the best one. It will loop only once, but it depends on good luck. The probability to get the right set is 1/nmp (which is a very
low chance in case the numbers are higher).

What is good or bad about this strategy?
We can not just trust our good luck. If the set of numbers have greater values, then the total combinations are higher. For example (6 x 10 x 6) will have 360 possible combinations. The times we ask assistant Jack is going to be random. It could be 360 times or just 1. Again to get the answer on the first try we have the probability of 1 / 360. (Which is a lower possibility).

### My solution
Assistant Jack returns a value that can be used to obtain a hint where the value is wrong on the set. We can reduce the time the while loop iterates with this clue. For example, if all the permutations are given by the formula ( n x m x p) we can calculate the lowest number of sets that the loop will iterate to obtain the correct one by doing this.

For the correct set of answer S ={ 2,3,2 }
```
1. First the desired set to get A = { 2, 3, 2} 
2. Second, the starting point of the guessing set G = { 1 , 1 , 1} 
3. Times the first element of G to reach the first element of A   (n -`n)
4. Times the second element of G to reach the second element of A (m-`m)
5. Times the third element of G to reach the third element of A (p -`p)
6. Hence (n-1) + (m-1) + (p-1)  = n+m+p-3
7. The formula gives us the total times the loop will iterate until it reaches the correct set of answers.
```


Pseudocode for MySolution.java 


```bash
//Set of right answer:   n = 2 , m=3 , p=2
n = 1
m = 1
p= 1
 WHILE TRUE:
	CALL answer  => assistantJack(n,m,p)
	IF answer == 1:
		n++
	ELSE IF answer ==2:
		m++
	ELSE IF answer == 3:
		p++
	IF  answer == 0:
		BREAK;
		
```

We start with a base case: every variable is set to 1. Each time assistantJack returns an index we know what variable was wrong, so the algorithm increments that variable. In the case some of the variables are correct, jack only returns the location of the variable is incorrect. That will reduce the total times we ask assistant jack considerably. In this case ( n =  2 , m =3 , p =2 ) this loop will repeated four times.  (n + m + p) - 3  = ( 2 + 3 +2 ) - 3 = 4

### Total steps for variables to reach the right value. 


Total time variables will increment to obtain its right value


```

A = { 2, 3, 2 }
      ^  ^  ^
      |  |  |  
      n  m  p

B = { 1, 1, 1 }    <- starting values of the guessing set.
``` 



initial-value-of-var B|var-to-reach A| total times Jack returns it is wrong
----------------------|--------------|-------------------------------------
1 | 2    |   1 
1| 3 |  2
1| 2 | 1
 |   |   | 4



This demostrates that the solution can be obtained in less or equal to 20 tries and it is only feasible for any set of the type S= {6,10,6} (no mather the order of the set) 


