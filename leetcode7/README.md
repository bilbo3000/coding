# Summary

## Misc
* Find mid bias towards left: int mid = (i + j) / 2; 
* Find mid bias towards right: int mid = (i + j) / 2 + 1; 

## Array
* Get array length: arr.length
* Create a 2D array: int[][] m = new int[n][n];
* Create and initialize an array: int[] arr = new int[] {1, 2, 3};

## Arrays
* asList(). 
Note that this is BAD: 
int[] A = new int[]{1, 2, 3}; 
List<Integer> list = Arrays.asList(A);
Cause Integer type vs int type. 

* binarySearch(A, 641)

* copyOf(A)

* copyOfRange(A, 1, 5)

* equals(A, B)

* fills(A, 42)
int[] count = new int[26];
Arrays.fills(count, 0);

* find(A, 28)

* sort(A)

* sort(A, cmp)

* toString()

How to print an array: 
Arrays.toString(myarr);

## Set

## List
* Copy set to a list: List<Integer> list = new ArrayList<>(set);

## Collection 
* Swap two elements of a collection: Collections.swap(c, i, j);
* Sort a list: Collections.sort(list);


## String
* Get String length: s.length()
* Get a char from a String: char ch = text.charAt(0);
* Get substring from index i to j: s.substring(i, j + 1);

## Deque
* add(x)/addLast(x): add to the tail; 
* push(x)/addFirst(x): add to the head; 
* iterator(): return an iterator of this equeue; 
* descendingIterator(): Returns an iterator that has the reverse order for this deque.
* pop(): Removes an element from the head and returns it.
* removeFirst(): Removes the element at the head.
* removeLast(): Removes the element at the tail.
* http://www.geeksforgeeks.org/deque-interface-java-example/

## Queue

## Stack
* push(x)
* pop()
* peek()
* https://www.tutorialspoint.com/java/java_stack_class.htm

## PriorityQueeu
* boolean add(E element): This method inserts the specified element into this priority queue.
* public remove(): This method removes a single instance of the specified element from this queue, if it is present
* public poll(): This method retrieves and removes the head of this queue, or returns null if this queue is empty.
* public peek(): This method retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
* iterator(): Returns an iterator over the elements in this queue.
* boolean contains(Object o): This method returns true if this queue contains the specified element
