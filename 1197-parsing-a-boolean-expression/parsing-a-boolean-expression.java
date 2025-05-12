class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == ',') {
                continue;
            } else if (ch != ')') {
                stack.push(ch);
            } else {
                // evaluate inside of ()
                Set<Character> seen = new HashSet<>();
                while (stack.peek() != '(') {
                    seen.add(stack.pop());
                }
                stack.pop(); // remove '('
                char operator = stack.pop();

                if (operator == '!') {
                    stack.push(seen.contains('t') ? 'f' : 't');
                } else if (operator == '&') {
                    stack.push(seen.contains('f') ? 'f' : 't');
                } else if (operator == '|') {
                    stack.push(seen.contains('t') ? 't' : 'f');
                }
            }
        }

        return stack.pop() == 't';
    }
}