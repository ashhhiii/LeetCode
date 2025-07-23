class Solution {
    public int maximumGain(String s, int x, int y) {
       if (x > y) {
            return removePattern(s, "a", "b", x, y);
        } else {
            return removePattern(s, "b", "a", y, x);
        }
    }

    private int removePattern(String s, String firstChar, String secondChar, int firstScore, int secondScore) {
        int totalScore = 0;
        Stack<Character> stack = new Stack<>();

        
        StringBuilder remaining = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == firstChar.charAt(0) && c == secondChar.charAt(0)) {
                stack.pop(); 
                totalScore += firstScore;
            } else {
                stack.push(c);
            }
        }

      
        while (!stack.isEmpty()) {
            remaining.append(stack.pop());
        }
        s = remaining.reverse().toString(); 

       
        stack.clear();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == secondChar.charAt(0) && c == firstChar.charAt(0)) {
                stack.pop(); 
                totalScore += secondScore;
            } else {
                stack.push(c);
            }
        }

        return totalScore;
    }
}