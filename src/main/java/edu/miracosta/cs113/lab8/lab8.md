Trace the following fragment for a Stack\<String\> s and an empty queue q ( type Queue\<String\> ).

```java
   String item;
   while ( !s.empty() ){
	item = s.pop();
	q.offer(item);
   }
   while( !q.isEmpty() ){
	item = q.remove();
	s.push(item);
   }
	
```


a) 

What is stored in stack s after the first loop executes? It is empty. 

What is stored in queue q after the first loop executes? q contains all the data previuosly stored in s.
 

b) 

What is stored in stack s after the second loop executes? s contains all the data previuosly stored in q
 
What is stored in queue q after the second loop executes? q is empty.
