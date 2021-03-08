## Lab 7


```java
boolean empty(){
 return thaData.size() == 0;
}
```


```java
E peek() {
 if empty() 
 {
   throw new EmptyStackException();
 }
 return theData.get(theData.size() -1 );
}
```


```java
E pop() {
if ( empty() ){
 throw new EmptyStackException();
} 
return theData.remove(theData.size() -1 );

}
```


```java
E push(E obj) {
  theData.add(obj);
  return obj;
}
```

c)
names  |
-------|   
Philip |
Dustin |
Robin  |
Debbie |
Rich   |

1)
```java
  names.push("Jane")    // adds Jane to the top of the stack and returns Jane
  names.push("Joseph")  //adss Joseph to the top of the stack and returns Joseph
  String top = names.pop()  // Returns the name Joseph and removes it from the  top of the stack 
  Strinf nextTop = names.peek()  // Returns Jane without removing it from the top of the stack.
  
```

2)

```java
while ( !names.isEmpty() ){   //Loops until names is empty theData.size() == 0
	System.out.println(names.pop()); //Prints to stdout the names that are in the top of the stack. 
					// Philip, Dustin , Robin, Debbie, Rich.
}
```

3)

What would be the effect of using peek instead of pop in Question 2.
The while loop would iterate infinitly printing Philip again and again because the stack will remain the same size.


