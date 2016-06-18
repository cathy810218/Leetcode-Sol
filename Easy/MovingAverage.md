# Moving Average from Data Stream

Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,

````Java
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
````

[Link to Leetcode](https://leetcode.com/problems/moving-average-from-data-stream/)

[Link to Code](MovingAverage.java)

--------------------------

## Solutions

Create a queue so when the element in the queue is more than the max size,
then we remove the first one that was added in the queue.

As the example shown above:

MovingAverage m = new MovingAverage(3) -> the max size is 3 for the queue
````
m.next(1)  -> [1]
m.next(10) -> [1 10]
m.next(3)  -> [1 10 3]
m.next(5)  -> [10 3 5]  //Remove 1
````
And we just need to sum up the values in the queue and return the value.


To do this,

we create three private variables `sum`, `maxSize` and `currentQueue`.


In the constructor, we initialize the data structure 

`currentQueue = new LinkedList<Integer>();` 

and set the `maxSize` to the input `size` (the size of queue cannot exceed the `maxSize`)



In `next(int val)`,

we keep adding up the input `val` to `sum` and put the `val` in `currentQueue`.

If `currentQueue` size is greater than `maxSize`,
we need to remove the **first** value that was added in the `currentQueue` and
subtract that value from `sum`.


Then return the `sum` / the size of `currentQueue`

