class MedianFinder {
    private PriorityQueue<Integer> leftHalf;
    private PriorityQueue<Integer> rightHalf;

    public MedianFinder() { 
        leftHalf = new PriorityQueue<>((a,b)->b-a);
        rightHalf = new PriorityQueue<>();       
    }
    
    public void addNum(int num) {
     if (leftHalf.isEmpty() || num <= leftHalf.peek()) {
            leftHalf.offer(num); // Insert into Max-Heap
        } else {
            rightHalf.offer(num); // Insert into Min-Heap
        }

        // Step 2: Balance the heaps
        if (leftHalf.size() > rightHalf.size() + 1) {
            rightHalf.offer(leftHalf.poll()); // Move largest from leftHalf → rightHalf
        } else if (rightHalf.size() > leftHalf.size()) {
            leftHalf.offer(rightHalf.poll()); // Move smallest from rightHalf → leftHalf
        }
    }

    public double findMedian() {
        if (leftHalf.size() == rightHalf.size()) {
            return (leftHalf.peek() + rightHalf.peek()) / 2.0; // Even case
        } else {
            return leftHalf.peek(); // Odd case (Max-Heap root is median)
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */