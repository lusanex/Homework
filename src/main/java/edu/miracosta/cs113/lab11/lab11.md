## Lab 11

```java
Set<String> s = new HashSet<>() // Creates a new Set of String type 
s.add("hello");   //Adss hello to the set
s.add("bye");   // Addsbye to the set
s.addAll(s);    // Do nothing return false
Set<String> t = new TreeSet<>()  // Creates a tree of String type
t.add("123") ;   // 123 is added to t
t.addAll(t);     // t is not added return false
System.out.println(s.containsAll(t));   //prints false s does not contain t
System.out.println(t.containsAll(s));  //prints false
System.out.println(s.contains("ace"));  //prints false
System.out.println(s.contains("123"));  //prints false;
s.ratainAll(t) //removes from s all of its elements that are not contained in t.
s.contains("123") // false
t.contains("123") // True

```


```java
a) c = a.addAll(b);

b) c = a.retainsAll(b);

c) c = a.removeAll(b);

d) if ( b.containsAll(a) ){
	c= a;
}
else {
	c = b;
}


```


