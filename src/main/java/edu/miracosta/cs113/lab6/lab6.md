## Lab 6

a) Each node in a single-linked list, has a reference to **next node** and **E data**

b) In a double-linked list , each node has a reference to, **next node**,**previous node**, and **E data**

c) To remove an item from a single-linked list, you need a reference to, **the previuos node**

d) To remove an item from a double-linked list, you need a reference to, **the node to remove**


```java
   Node<String> nodeRef = tail.prev;  // NodeRef references to the second last node Temp node
   nodeRef.prev.next = tail;          // The third last next points to tail
   tail.prev = nodeRef.prev;         // The second last Node points to the third last Node. The second last node is removed.

```


```java
  Node<String> nodeRef = head     //nodeRef points to the beginning of the list
  head = = new Node<String>("Tamika"); // Head points to a new Node "Tamika"
  head.next = nodeRef      // head next points to the old list.
  nodeRef.prev = head      // old list points to the new head
  
```


```java
   Node<String> nodeRef = new Node<String>("Shakira");  // New node with the data "Shakira"
   nodeRef.prev = head   //the node Shakira prev points to head
   nodeRef.next = head.next   // Shakira node next points to the second elemnt of the list
   head.next.prev = nodeRef   // Second node previuos points to shakira
   head.next = nodeRef        // Second node next points to Shakira the operations makes shakira the second node of the list. 
```



```java
   int indexOfSam = myList.indexOf("Sam");    //gets index of sam
   ListIterator<String> iteratorToSam = listIterator(indexOfSam); //starts the iterator class at index sam
   iteratorToSam.previuos();  // Moves the iterator one node before sam
   iteratorToSam.remove(); // removes node sam;
```



```java
3.2 iteratorToSam.next(); removes node sam
3.3 if we omit the statement previuos() method, it throws an IllegalStateException.
because no call to next or previuos methods has been done. ```











