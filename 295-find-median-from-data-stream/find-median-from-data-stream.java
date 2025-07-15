class MedianFinder {
    private PriorityQueue<Integer> leftHalf;
     private PriorityQueue<Integer> rightHalf;


    public MedianFinder() {
        leftHalf = new PriorityQueue<>((a,b) -> b-a);
        rightHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(leftHalf.isEmpty() || num < leftHalf.peek()){
            leftHalf.offer(num);
        }else{
            rightHalf.offer(num);
        }
        if(leftHalf.size() > rightHalf.size()+1){
            rightHalf.offer(leftHalf.poll());
        }else if (rightHalf.size() > leftHalf.size()) {
            leftHalf.offer(rightHalf.poll());
        }
    }
    
    public double findMedian(){
        if(leftHalf.size() == rightHalf.size()){
            return (leftHalf.peek() + rightHalf.peek())/2.0;
        }else{
            return leftHalf.peek();
        }

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */