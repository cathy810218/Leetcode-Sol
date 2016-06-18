public class MovingAverage {
    private Queue<Integer> currentQueue;
    private int maxSize;
    private double sum = 0.0;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        currentQueue = new LinkedList<Integer>(); // how you initialize a queue in java
        maxSize = size;
    }
    
    public double next(int val) {
        sum += val;
        currentQueue.add(val); // add an element in the queue
        
        if (currentQueue.size() > maxSize) {
            int temp = currentQueue.remove();
            sum -= temp;
        }
        
        return sum / currentQueue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */