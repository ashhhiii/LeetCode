class Solution {
    public boolean lemonadeChange(int[] bills) {
       int five = 0, ten = 0; // Track $5 and $10 bills

        for (int bill : bills) {
            if (bill == 5) {
                five++; // Collect $5 bill
            } else if (bill == 10) {
                if (five == 0) return false; // No $5 bill to give change
                five--;  // Give one $5 as change
                ten++;   // Collect $10 bill
            } else { // bill == 20
                if (ten > 0 && five > 0) { // Prefer $10 + $5 change
                    ten--;
                    five--;
                } else if (five >= 3) { // Otherwise, use three $5 bills
                    five -= 3;
                } else {
                    return false; // Cannot give correct change
                }
            }
        }
        return true; // Successfully served all customers
    }

}