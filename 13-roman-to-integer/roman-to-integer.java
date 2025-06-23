class Solution {
    public int romanToInt(String s) {
         Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;  // Stores the final result

        // Traverse the string from left to right
        for (int i = 0; i < s.length(); i++) {
            int currentValue = romanMap.get(s.charAt(i));
            // Check if there is a next character and its value is larger (for subtraction cases)
            if (i < s.length() - 1 && currentValue < romanMap.get(s.charAt(i + 1))) {
                result -= currentValue;  // Subtract the current value
            } else {
                result += currentValue;  // Add the current value
            }
        }
        return result;
    }
    }
