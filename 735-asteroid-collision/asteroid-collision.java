class Solution {
    public int[] asteroidCollision(int[] asteroids) {
         Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            // Handle collisions
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int top = stack.peek();
                if (Math.abs(asteroid) > top) {
                    stack.pop(); // The positive asteroid explodes
                } else if (Math.abs(asteroid) == top) {
                    stack.pop(); // Both asteroids explode
                    asteroid = 0; // Break the loop as the current asteroid is gone
                } else {
                    asteroid = 0; // The current asteroid explodes
                }
            }
            if (asteroid != 0) {
                stack.push(asteroid); // Add the asteroid to the stack if it's still valid
            }
        }
        
        // Convert stack to an array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

}