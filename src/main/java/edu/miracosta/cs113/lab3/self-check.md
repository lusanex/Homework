# SELF-CHECK 
* a)


The outer loop is excuted n times.\
The inner loop is executed n times.

i = value
n = n times loop will executed
 
j = times the inner loop is executed

hence n * n = times the loops are executed

<a alt="n^2" href="https://www.codecogs.com/eqnedit.php?latex=n^2" target="_blank"><img src="https://latex.codecogs.com/gif.latex?n^2" title="n^2" /></a>

Big O notation :  <a alt="**O(N^2)**" href="https://www.codecogs.com/eqnedit.php?latex=O(n^2)" target="_blank"><img src="https://latex.codecogs.com/gif.latex?O(n^2)" title="O(n^2)" /></a>


n = 6


i < n| 0|1|2|3|4|5
-----|--|-|-|-|-|-
j|6|6|6|6|6|6



```java
for( int i = 0; i< n; i++ )
	for ( int j = 0 ; j < n; j++ )
		System.out.println(i + " " + j);
``` 




* b)

This loop is executed n times by the constant 2. To get the total times the loop iterates : <a alt="n * 2" href="https://www.codecogs.com/eqnedit.php?latex=n*2" target="_blank"><img src="https://latex.codecogs.com/gif.latex?n*2" title="n*2" /></a>


Big O notation: <a href="https://www.codecogs.com/eqnedit.php?latex=O(2n)" target="_blank"><img alt = "O(2n)" src="https://latex.codecogs.com/gif.latex?O(2n)" title="O(2n)" /></a>


```java
for( int = 0 ; i < n; i++ )
	for ( int j = 0 ; j < 2 ; j++ )
		System.out.println(i + " " +j);
```


i < n| 0|1|2|3|4|5
-----|--|-|-|-|-|-
j|2|2|2|2|2|2


* c)

The next loop follows the series of  <a alt = " n-1 + n-2 + n-3 ... ... 1" href="https://www.codecogs.com/eqnedit.php?latex=n-1&space;&plus;&space;n-2&space;&plus;&space;n-3&space;...&space;1" target="_blank"><img src="https://latex.codecogs.com/gif.latex?n-1&space;&plus;&space;n-2&space;&plus;&space;n-3&space;...&space;1" title="n-1 + n-2 + n-3 ... 1" /></a>

The next formula gets the total times the loop iterates:  <a alt="n^2 + n / 2" href="https://www.codecogs.com/eqnedit.php?latex=\frac{n^2&space;&plus;n&space;}{2}" target="_blank"><img src="https://latex.codecogs.com/gif.latex?\frac{n^2&space;&plus;n&space;}{2}" title="\frac{n^2 +n }{2}" /></a>

Big O notation:  <a href="https://www.codecogs.com/eqnedit.php?latex=O(n^2)" alt="O(n^2)" target="_blank"><img src="https://latex.codecogs.com/gif.latex?O(n^2)" title="O(n^2)" /></a>

```java
for ( int i = 0 ; i< n; i++ )
	for (int j= n-1 ; j >=i; j--)
		System.out.println(i + " "+j);
```
i < n| 0|1|2|3|4|5
-----|--|-|-|-|-|-
j|6|5|4|3|2|1


* d)

With out counting the times the if statment its true: The  for loops are executed by the next formula;
<a alt="n^2-n / 2" href="https://www.codecogs.com/eqnedit.php?latex=\frac{n^2-n}{2}" target="_blank"><img src="https://latex.codecogs.com/gif.latex?\frac{n^2-n}{2}" title="\frac{n^2-n}{2}" /></a>

It follows the same series pattern:  

<a href="https://www.codecogs.com/eqnedit.php?latex=\sum_{i=0}^{n}&space;i&plus;1" target="_blank"><img src="https://latex.codecogs.com/gif.latex?\sum_{i=0}^{n}&space;i&plus;1" title="\sum_{i=0}^{n} i+1" /></a>


Big O notation:  <a href="https://www.codecogs.com/eqnedit.php?latex=O(n^2)" alt="O(n^2)" target="_blank"><img src="https://latex.codecogs.com/gif.latex?O(n^2)" title="O(n^2)" /></a>


```java
for ( int i = 1; i < n; i++ )
	for ( int j = 0 ; j < i; j++ )
		if ( j % i == 0 )
			System.out.println(i + " "+j);
```



i < n| 1|2|3|4|5|
-----|--|-|-|-|-|
j|1|2|3|4|5|6









