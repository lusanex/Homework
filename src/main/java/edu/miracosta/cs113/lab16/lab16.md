## Dijkstra's shortes path

initial set 
* { INF, INF,  INF, INF, INF, INF, INF, INF }
We choose a starting vertex\
Starting point vertex 0

* { 0 , INF,  INF, INF, INF, INF, INF, INF }

adjacentes vertices of 0 are 1 and 7 with a weight of 4 and 8.\
* { 0 , 1,  INF, INF, INF, INF, INF, INF }


adjacent vertex of 1 is 2 and its weight 12\
Now set has the vertex 1
* { 0 , 1,  INF, INF, INF, INF, INF, INF }

We choose the next minimum distance value which is 7 and we add it to the set. The adjacents vertices are updated 8 and 6 and its weights to 15 an 9.
* { 0 , 1,  7, INF, INF, INF, INF, INF }

We pick the vertex with the minimum weight which is 9 and add the vertex 6 to the set 
* { 0 , 1, 7, 6, INF, INF, INF, INF }

we Update the weight of the adjacent vertices 8 and 5 to 15 and 11.\
We pick the next vertex with the lowest weight 5.
* { 0,1,7,6,5,INF,INF,INF,INF }

Update the weight of the adjacent vertices  2 , 3 , 4 to 15, 25,21
Pick the next vertex with the lowest weight and is not in the set.

* { 0,1,7,6,5,4,INF,INF,INF }

Update the weight of the adjacent vertices 3 


