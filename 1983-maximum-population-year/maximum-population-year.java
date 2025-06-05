class Solution {
    public int maximumPopulation(int[][] logs) {
         int[] years = new int[101]; // years[0] = 1950, years[100] = 2050

        // Mark the population change
        for (int[] log : logs) {
            years[log[0] - 1950]++;   // Birth year: population increases
            years[log[1] - 1950]--;   // Death year: population decreases (exclusive)
        }

        int maxPopulation = 0;
        int year = 1950;
        int currentPopulation = 0;

        for (int i = 0; i < 101; i++) {
            currentPopulation += years[i];
            if (currentPopulation > maxPopulation) {
                maxPopulation = currentPopulation;
                year = 1950 + i;
            }
        }

        return year;
    
    }
}