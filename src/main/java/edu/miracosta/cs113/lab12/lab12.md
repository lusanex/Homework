1.- If you were using a Map to store the following list of items, which data field would you select the key, and why?

The map key must be unique.

a) ISBN because each book has unique numberic number

b) uniform number

c)model number 

d)course ID


2.- For the Map index en Example 7.4 what key-value pairs would be stored for each token in the following data field?

Key(String) Value(ArrayList)

this [1]\
line [1,2,3] \
is [1,2] \
first [1] 
and [2] \
2 [2]\
second [2]\
followed [3]\
by [3] \
the[3]\
third [3]

3.- 
```
lines = index.get("this") // the arraylist lines has the value set[1]
lines = index.get("that") // lines null does not exist "that"
lines = index.get("line") // it set the value set to [1,2,3]
lines.add(4) // adds the array list [1,2,3,4]
lines.put("is",lines) // key ("is") -> [1,2,3,4] bounded

```

