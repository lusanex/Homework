
# Big-O notation 


1  **O(0)**
2  **O(5)**
3  **O(2/N)**          //   { n | n > 0 } the set of all natural number such as n > 0 
4  **O(log N)**
5  **O(sqrt(N))**      // sqrt(N) = N ^ 1/2 
6  **O(N)**            
7  **O(N^1.5)**
8  **O(N log N)**
9  **O(N^2)**
10 **O(NM)**           // { M | M > N } the set of all natural numbers such as M > N
11 **O(N^4)**
12 **O(2^N)**
13 **O(INFINITY)**



Total number of steps is given by n so
T = { 1 + 1 + 1 ... n } N times
T(n) = O(N)
```
sum = 0;
for ( int = 0 ; i < n ; i++ ) {   // N times
    sum++;
}
```


Two loops 
The inner loop is repeated n times by the
n times of the outer loop.
T = { n * n } = n^2
T(n) = O(N^2)

```
sum = 0;
for ( i = 0 ; i < n ; i++ ){                  //  N times
	for ( int j = 0 ; j < n ; j++ ){      // N times
	 	sum++;
	}
}

```

Two loops the first loop is repeated n times
the inner loop grows by 1 following the natural number
series pattern { 1, 2, 3 ... ...n }  to get the total number
we use the next formula  n (n + 1) / 2
Total steps:  we multiplie N times ( outer loop ) * n(n + 1) /2 (times inner loop)
n + n (n + 1_) / 2
simplifying 

n + ( n^2 + n / 2 )

2n + n^2 + n / 2

n^2 + ( 3n / 2 )

T(n) = O(n^2)

```
sum = 0;
for ( i = 0 ; i < n ; i++ ){                  //  N times
	for ( int j = 0 ; j < i ; j++ ){      //  { 1 + 2 + 3 ... ... n } Sum of the first n number of the series 
	 	sum++;                        //  n ( n+ 1) /2
	}
}


```

Two loops
The first loop is repeated N * N times
The inner loop is repeated N * N times
To get the total steps and time complexity we do the next

N * N =  N ^ 2
N * N = N ^ 2
( N ^2 ) * ( N ^ 2 )

( N ^ 4 ) - >  T(n) = O(N ^ 4)
```
sum = 0;
for ( i = 0 ; i < n*n ; i++ ){                  //  N * N times
	for ( int j = 0 ; j < n * n ; j++ ){      // N  * N times
	 	sum++;
	}
}

```

