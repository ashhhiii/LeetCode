class Solution {
    public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        // Iterate through the array
        for (int price : prices) {
            // Update the minimum price seen so far
            if (price < minPrice) {
                minPrice = price;
            }
            // Calculate profit if the stock is sold at the current price
            int profit = price - minPrice;

            // Update the maximum profit if this profit is greater
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        // Return the maximum profit
        return maxProfit;
    }

    
}