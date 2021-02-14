# SELF-CHECK 
* a)
```java
for( int i = 0; i< n; i++ )
	for ( int j = 0 ; j < n; j++ )
		System.out.println(i + " " + j);
``` 



The outer loop is excuted n times.\
The inner loop is executed n times.\
i = value
n = n times loop will executed \
j = times the inner loop is executed\ 

n = 6


i < n| 0|1|2|3|4|5
-----|--|-|-|-|-|-
j|6|6|6|6|6|6

hence n * n = times the loops are executed

n^2

**O(n^2)**

* b)
```java
for( int = 0 ; i < n; i++ )
	for ( int j = 0 ; j < 2 ; j++ )
		System.out.println(i + " " +j);
```


i < n| 0|1|2|3|4|5
-----|--|-|-|-|-|-
j|2|2|2|2|2|2


* c)
```java
for ( int i = 0 ; i< n; i++ )
	for (int j= n-1 ; j >=i; j--)
		System.out.println(i + " "+j);
```
i < n| 0|1|2|3|4|5
-----|--|-|-|-|-|-
j|6|5|4|3|2|1


* d)
```java
for ( int i = 1; i < n; i++ )
	for ( int j = 0 ; j < i; j++ )
		if ( j % i == 0 )
			System.out.println(i + " "+j);
```



i < n| 1|2|3|4|5|
-----|--|-|-|-|-|
j|1|2|3|4|5|6









