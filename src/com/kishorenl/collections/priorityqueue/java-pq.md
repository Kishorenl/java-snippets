

## Priority Queue

The default PriorityQueue is implemented with <mark>Min-Heap<mark>, that is the top element is the minimum one in the heap.

In order to implement a max-heap, you can create your own Comparator:

import java.util.Comparator;

public class MyComparator implements Comparator<Integer>
{
    public int compare( Integer x, Integer y )
    {
        return y - x;
    }
}
So, you can create a min-heap and max-heap in the following way:

PriorityQueue minHeap=new PriorityQueue();
PriorityQueue maxHeap=new PriorityQueue(size, new MyComparator());

We can add size as the first argument to PriorityQueue

So, overal for maxHeap we can use from Java1.8

PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());

##  ArraySorting

Default is ascending order

if we want to change int

Arrays.sort(arr, new Comparator<Integer>() {
     public int compare(Integer x, Integer y) {
         return y - x;
     }
});

(or)

Arrays.sort(arr, (Integer x, Integer y) -> y - x);