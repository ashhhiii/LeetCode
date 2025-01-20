class MyStack {
private Queue<Integer> q1;
    private Queue<Integer> q2;

    
      public MyStack() {
        
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Pushes element x to the top of the stack.
    public void push(int x) {
        q1.add(x); // Add element to the queue
    }

    // Removes the element on the top of the stack and returns it.
    public int pop() {
        // Transfer all elements except the last from q1 to q2
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        // The last element in q1 is the top of the stack
        int topElement = q1.poll();
        
        // Swap q1 and q2 so q1 contains the remaining elements
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    // Returns the element on the top of the stack.
    public int top() {
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int topElement = q1.peek(); // Get the front of q1, which is the top element
        q2.add(q1.poll()); // Add it to q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    // Returns true if the stack is empty, false otherwise.
    public boolean empty() {
        return q1.isEmpty();
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */