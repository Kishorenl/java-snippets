# Java Collections
A *collection* is a data structure---actually, an object---that can hold references to other objects. Usually, collections contain references to objects that are all of the same type. The collections-framework interfaces declare the operations to be performed generically on various types of collections.

| Interface | Description |
| --- | --- |
| Collection | The root interface in the collections hierarchy from which interfaces Set, Queue and List are derived. |
| Set | A collection that does not contain duplicates. |
| List | An ordered collection that can contain duplicate elements. |
| Map | A collection that associates keys to values and cannot contain duplicate keys. |
| Queue | Typically a first-in, first-out collection that models a waiting line; other orders can be specified. |

[![](http://en.proft.me/media/java/collectionsTable.png)](http://pedrocardoso.eu/scjp-java-collections-cheat-sheet/)

[![](http://zeroturnaround.com/wp-content/uploads/2016/04/Java-Collections-cheat-sheet.png)](http://zeroturnaround.com/wp-content/uploads/2016/04/Java-Collections-cheat-sheet.png)

The `List` is the base interface for all list types, and the `ArrayList` and `LinkedList` classes are two common List's implementations.

-   `ArrayList`. An implementation that stores elements in a backing array. The array's size will be automatically expanded if there isn't enough room when adding new elements into the list. It's possible to set the default size by specifying an initial capacity when creating a new `ArrayList`. Basically, an `ArrayList` offers constant time for the following operations: `size`, `isEmpty`, `get`, `set`, `iterator`, and `listIterator`; amortized constant time for the add operation; and linear time for other operations. Therefore, this implementation can be considered if we want fast, random access of the elements.
-   `LinkedList` : An implementation that stores elements in a doubly-linked list data structure. It offers constant time for adding and removing elements at the end of the list; and linear time for operations at other positions in the list. Therefore, we can consider using a `LinkedList` if fast adding and removing elements at the end of the list is required.

Array

Array are fixed length data structure.

Creating an array
```
int[] intArray = new int[10];

Creating and initializing array in same line

int[] intArray3 = new int[]{1,2,3,4};

Loop array

for(int i: numbers){
   System.out.println(i);
}

Sort array

String[] companies = { "Google", "Apple", "Sony" };
Arrays.sort(companies);

Sort array in reverse order

Arrays.sort(companies, Collections.reverseOrder());

Creating an multi-dimensional array

int[][] multiArray = new int[2][3];

Creating and initializing multi-dimensional array in same line

int[][] multiArray = {{1,2,3},{10,20,30}};
```
ArrayList

Advantage of *ArrayList* is that it can resize itself. Since we can not modify size of an array after creating it, we prefer to use ArrayList in Java which re-size itself automatically once it gets full. *ArrayList* in Java implements List interface and allow *null*. Java *ArrayList* also maintains insertion order of elements and allows duplicates opposite to any *Set* implementation which doesn't allow duplicates.

You can use ArrayList in Java with or without Generics both are permitted. Generics version is recommended because of enhanced type-safety.

ArrayList<String> stringList = new ArrayList<String>();

Putting an item into *ArrayList*

stringList.add("one");
stringList.add("two");

To assign to a position, we use `set`. The index must be valid. The `ArrayList` must already *contain* a reference at the index.

collection.set(1, 10);

An empty `ArrayList` has no elements. When we call `clear()` on an `ArrayList`, it will become empty. This method is useful when we want to reuse an existing `ArrayList`.

`isEmpty()` method returns true if the `ArrayList` has zero elements.

With `remove()` method we delete an element. The element slot is removed and any later elements are shifted forward. We can use an index or a value argument.

If we pass a value, `remove()` searches for the first occurrence and removes that element. This is slower than using an index.

collection.remove(1); // by position
collection.remove("item1"); // by value

With `Collections.addAll` we add many elements to an `ArrayList` at once. The second argument is either an array of the elements to add, or those elements as arguments.
``` 
//import java.util.ArrayList;
//import java.util.Collections;

ArrayList<Integer> values = new ArrayList<>();
Integer[] array = { 10, 20, 30 };

// add all elements in array to ArrayList
Collections.addAll(values, array);

// add more elements
Collections.addAll(values, 40, 50);

*Checking Index of an Item in Java Arraylist*

You can use `indexOf()` method of *ArrayList* in Java to find out index of a particular object.

int index = stringList.indexOf("Item"); //location of Item object in List

*Creating ArrayList from Array in Java*

ArrayList<String> stringList = Arrays.asList(new String[]{"one", "two", "three");

Convert Array to ArrayList in Java

String[] numbers = {"one", "two", "three"};
List numberList = Arrays.asList(numbers);

Iterate over list

for(String item : numberList){
    System.out.println(item);
}

Sort ArrayList

List collection = new ArrayList();
collection.add(1);
collection.add(4);
collection.add(2);
collection.add(3);
Collections.sort(collection);

Sort ArrayList in reverse order

List collection = new ArrayList();
collection.add(1);
collection.add(4);
collection.add(2);
collection.add(3);
Collections.sort(collection, Collections.reverseOrder());

```
Sometimes we need to check whether an element *exists in ArrayList* in Java or not for this purpose we can use `contains()` method of Java. `contains()` method takes the type of object defined in ArrayList creation and returns true if this list contains the specified element.
``` 
List array = Arrays.asList(1, 3, 5, 2, 4);
if (array.contains(3)) {
    System.out.println("Element found inside ArrayList");
};
```
Difference between LinkedList and ArrayList

Main difference between ArrayList and LinkedList is that ArrayList is implemented using resizable array while LinkedList is implemented using doubly LinkedList.

Here are another differences

1) Insertions are easy and fast in LinkedList as compared to ArrayList because there is no risk of resizing array and copying content to new array if array gets full which makes adding into ArrayList of O(n) in worst case, while adding is O(1) operation in LinkedList. ArrayList also needs to update its index if you insert something anywhere except at the end of array.

2) Removal is like insertions better in LinkedList than ArrayList.

3) LinkedList has more memory overhead than ArrayList because in ArrayList each index only holds actual object (data) but in case of LinkedList each node holds both data and address of next and previous node.

```
LinkedList l = new LinkedList();
l.add("A1");
l.add("B");
l.add("C");
l.addLast("Z");
l.add(1, "A0");

l.remove("B");
l.remove(2);

Object v = l.get(2);
l.set(2, (String) v + "0");
```
There are few similarities between these classes which are as follows:

-   Both `ArrayList` and `LinkedList` are implementation of `List` interface.
-   They both maintain the elements insertion order which means while displaying `ArrayList` and `LinkedList` elements the result set would be having the same order in which the elements got inserted into the `List`.
-   Both these classes are non-synchronized and can be made synchronized explicitly by using `Collections.synchronizedList` method.
-   The `iterator` and `listIterator` returned by these classes are fail-fast (if list is structurally modified at any time after the iterator is created, in any way except through the iterator's own remove or add methods, the iterator will throw a `ConcurrentModificationException`).

Let's compare `LinkedList` and `ArrayList` by following parameters:

*1\. Implementation*. `ArrayList` is the resizable array implementation of `List` interface, while `LinkedList` is the Doubly-linked list implementation of the `List` interface.

*2\. Performance*. `ArrayList` `get(int index)` operation runs in constant time i.e O(1) while `LinkedList` `get(int index)` operation run time is O(n) .

The reason behind `ArrayList` being faster than `LinkedList` is that `ArrayList` uses index based system for its elements as it internally uses array data structure, on the other hand, `LinkedList` does not provide index based access for its elements as it iterates either from the beginning or end (whichever is closer) to retrieve the node at the specified element index.

`insert()` or `add(Object)` operation. Insertions in `LinkedList` are generally fast as compare to `ArrayList`. In `LinkedList` adding or insertion is O(1) operation. While in `ArrayList`, if array is full i.e worst case, there is extra cost of resizing array and copying elements to the new array, which makes runtime of add operation in `ArrayList` O(n), otherwise it is O(1) .

`remove(int)` operation. Remove operation in `LinkedList` is generally same as `ArrayList` i.e. O(n). In `LinkedList`, there are two overloaded `remove` methods. Oe is `remove()` without any parameter which removes the head of the list and runs in constant time O(1). The other overloaded remove method in `LinkedList` is `remove(int)` or `remove(Object)` which removes the `Object` or int passed as parameter. This method traverses the `LinkedList` until it found the `Object` and unlink it from the original list. Hence this method run time is O(n).

While in `ArrayList` `remove(int)` method involves copying elements from old array to new updated array, hence its run time is O(n).

*3\. Reverse Iterator*. `LinkedList` can be iterated in reverse direction using `descendingIterator()` while there is no `descendingIterator()` in `ArrayList`, so we need to write our own code to iterate over the `ArrayList` in reverse direction.

*4\. Initial Capacity*. If the constructor is not overloaded, then `ArrayList` creates an empty list of initial capacity 10, while `LinkedList` only constructs the empty list without any initial capacity.

*5\. Memory Overhead*. Memory overhead in `LinkedList` is more as compared to `ArrayList` as node in `LinkedList` needs to maintain the addresses of next and previous node. While in `ArrayList` each index only holds the actual object(data).

## Stack

```
import java.util.Stack;

Stack<String> stackOfCards = new Stack<>();
// push
stackOfCards.push("Jack");

// pop
String cardAtTop = stackOfCards.pop();  // Throws EmptyStackException if the stack is empty

// Peek
cardAtTop = stackOfCards.peek();

// isEmpty
stackOfCards.isEmpty(); // boolean

// Size
stackOfCards.size()

// Search for an element
// The search() method returns the 1-based position of the element from the top of the stack
// It returns -1 if the element was not found in the stack
int position = stackOfCards.search("Queen");

// Iteration
stackOfPlates.forEach(plate -> {
            System.out.println(plate);
        });
(or)
Iterator<String> platesIterator = stackOfPlates.iterator();
while (platesIterator.hasNext()) {
    String plate = platesIterator.next();
    System.out.println(plate);
}



```

## Queue

```
import java.util.LinkedList;
import java.util.Queue;

// Create and initialize a Queue using a LinkedList
Queue<String> waitingQueue = new LinkedList<>();

// Adding new elements to the Queue (The Enqueue operation)
waitingQueue.add("Rajeev");

// Removing an element from the Queue using remove() (The Dequeue operation)
// The remove() method throws NoSuchElementException if the Queue is empty
String name = waitingQueue.remove();

// Removing an element from the Queue using poll()
// The poll() method is similar to remove() except that it returns null if the Queue is empty.
name = waitingQueue.poll();

// Check if a Queue is empty
System.out.println("is waitingQueue empty? : " + waitingQueue.isEmpty());

// Find the size of the Queue
System.out.println("Size of waitingQueue : " + waitingQueue.size());


// Get the element at the front of the Queue without removing it using peek()
// The peek() method is similar to element() except that it returns null if the Queue is empty
firstPersonInTheWaitingQueue = waitingQueue.peek();

//Iterating over a Queue using Java 8 forEach()
waitingQueue.forEach(name -> {
    System.out.println(name);
});
 
(or)

Iterator<String> waitingQueueIterator = waitingQueue.iterator();
while (waitingQueueIterator.hasNext()) {
    String name = waitingQueueIterator.next();
    System.out.println(name);
}

```

## Set

Unlike List, Set doesn't keep insertion order and doesn't allow any duplicates.

``` 
ArrayList numbers = new ArrayList();
numbers.add("1");

//Converting ArrayList into HashSet in Java
HashSet numberSet = new HashSet(numbers);
numberSet.add("2");
numberSet.contains("3")
``` 
Popular implementation of List interface in Java includes ArrayList, Vector and LinkedList. While popular implementation of Set interface includes HashSet,<mark> TreeSet and LinkedHashSet.</mark>

``` 
How to do union, intersection and difference operation on two sets?

Set<String> s1, s2;

// union, s1 now contains all elements from both sets
s1.addAll(s2)

// or using stream
List<String> union = Stream.concat(s1.stream(), s2.stream())
        .distinct().sorted()
        .collect(Collectors.toList());

// intersection, s1 now contains only elements in both sets
s1.retainAll(s2);

// or using stream
List<String> intersection = s1.stream()
        .filter(s2::contains)
        .collect(Collectors.toList());

//difference, s1 now contains only elements from s1
s1.removeAll(s2);

// or using stream
List<String> aDiffB = s1.stream()
        .filter(i -> !s2.contains(i))
        .collect(Collectors.toList());

[disjoint](https://docs.oracle.com/javase/6/docs/api/java/util/Collections.html#disjoint%28java.util.Collection,%20java.util.Collection%29) returns true if the two specified collections have no elements in common.

boolean isCommonElementExist = Collections.disjoint(s1, s2);

```

### Hashset vs  linkedHashSet vs Tree set

| FEATURES | HASHSET | LINKEDHASHSET | TREESET |
| --- | --- | --- | --- |
| Internal Working | HashSet internally uses HashMap for storing objects | LinkedHashSet uses LinkedHashMap internally to store objects | TreeSet uses TreeMap internally to store objects |
| When To Use | If you don't want to maintain insertion order but want store unique objects | If you want to maintain insertion order of elements then you can use LinkedHashSet | If you want to sort the elements according to some Comparator then use TreeSet |
| Order | HashSet does not maintain insertion order | LinkedHashSet maintains insertion order of objects | While TreeSet orders of the elements according to supplied Comparator. Default, It's objects will be placed in their natural ascending order. |
| Complexity of Operations | HashSet gives O(1) complicity for insertion, removing and retrieving objects | LinkedHashSet gives insertion, removing and retrieving operations performance in order O(1). | While TreeSet gives performance of order O(log(n)) for insertion, removing and retrieving operations. |
| Performance | HashSet performance is better according to LinkedHashSet and TreeSet. | The performance of LinkedHashSet is slow to TreeSet. The performance LinkedHashSet is almost similar to HashSet but slower because, LinkedHashSet maintains LinkedList internally to maintain the insertion order of elements | TreeSet performance is better to LinkedHashSet excluding insertion and removal operations because, it has to sort the elements after each insertion and removal operations. |

> When to use HashSet, TreeSet and LinkedHashSet in Java:
* HashSet: If you don't want to maintain insertion order but want store unique objects.
* LinkedHashSet: If you want to maintain insertion order of elements then you can use LinkedHashSet.
* TreeSet: If you want to sort the elements according to some Comparator then use TreeSet.

```
LinkedHashSet<String> geekLinkSet  = new LinkedHashSet<>(); 
TreeSet<String> geekTreeSet = new TreeSet<>(); 
HashSet<String> geekHashSet = new HashSet<String>(); 

// add  and  remove is same
geekLinkSet.add(str); 
geekLinkSet.remove(str); 

//Iteration
for (String s : set) {
    System.out.println(s);
}
(or)
set.forEach(System.out::println);

```

## Map

Map in Java allows duplicate value which is fine with List which also allows duplicates but Map doesn't allow duplicate key.
``` 
HashMap<String, String> animals = new HashMap<String, String>();
animals.put("cat", "one");


// converting HashMap keys into ArrayList
List<String> keyList = new ArrayList<String>(animals.keySet());

// converting HashMap Values into ArrayList
List<String> valueList = new ArrayList<String>(animals.values());

//Iterating map

for (String key : animals.keySet()) {
   System.out.println("Key: " + key + " Value: " + animals.get(key));
}

`get()` method looks into the `HashSet` and, if found, returns the value for the key. *Please be careful not to call the `get()` method on a key that does not exist. An exception will be thrown.*

We can use the `containsKey` to see if the key exists. It returns *true* if the key is found, and *false* otherwise.

if (animals.containsKey('cat')) {
    System.out.println("cat was found");
}

`containsValue()` returns *true* if a specified value exists. To get keys with a value, we must use a loop, more than one key may have a single value.

if (animal.containsValue("two")) {
    System.out.println("two value detected!");

    // loop over all keys and print them if they have "two" values.
    for (String key : animals.keySet()) {
        if (animals.get(key) == "two") {
            System.out.println(key);
        }
    }
}

`size()` is the count of entries (or of keys).

`isEmpty()` returns *true* if the `HashMap` has a size of zero.

`getOrDefault` method safely get a value from `HashMap`. If the key does not exist, no error occurs. Instead, the default value (argument 2) is returned.

animals.getOrDefault("bird", -1);

`put()` will replace an existing value. But `putIfAbsent()` will not. It only adds the value to the `HashMap` if no key currently exists for it.

animals.putIfAbsent("mouse", "three");

A `HashMap` is unordered. It cannot be directly sorted, but we can *sort its keys* and process them (and their values) in order. We use `keySet` and add the keys to an `ArrayList`.

// put keys into an ArrayList and sort it
Set<String> set = animals.keySet();
ArrayList<String> list = new ArrayList<String>();
list.addAll(set);
Collections.sort(list);

// display sorted keys and their values
for (String key : list) {
    System.out.println(key + ": " + hash.get(key));
}
```
Hashtable

Hashtable is similar to HashMap, but is synchronized. Like HashMap, Hashtable stores key/value pairs in a hash table. When using a Hashtable, you specify an object that is used as a key, and the value that you want linked to that key. The key is then hashed, and the resulting hash code is used as the index at which the value is stored within the table.

HashMap allows null values as key and value whereas Hashtable doesn't allow nulls.

Hashtable<Integer, String> mapToString = new Hashtable<Integer,String>();
mapToString.put(new Integer(1), "Two");



Character:

char ch1 = 'A';
char ch2 = '1';

To check whether number or alphabet
Character.isLetterOrDigit(ch1); // true
Character.isLetterOrDigit(ch2); //true

Character.isLetter(ch1); //true
Character.isDigit(ch1); // false 
Character.isDigit(ch2); //true


##  Checking a list  is sublist of the other

int index=Collections.indexOfSubList(list , sublist);

if it returns -1, then its not a sublist