class Solution {
    public int leastInterval(char[] tasks, int n) {
          int[] taskCounts = new int[26];
        for (char task : tasks) {
            taskCounts[task - 'A']++;
        }
        
        // Step 2: Sort task frequencies in descending order
        Arrays.sort(taskCounts);
        
        // Step 3: Find the maximum frequency
        int maxFreq = taskCounts[25];
        int idleSlots = (maxFreq - 1) * n;
        
        // Step 4: Fill idle slots with remaining tasks
        for (int i = 24; i >= 0 && idleSlots > 0; i--) {
            idleSlots -= Math.min(taskCounts[i], maxFreq - 1);
        }
        
        // Step 5: Handle negative idle slots (no idling required)
        idleSlots = Math.max(0, idleSlots);
        
        // Total intervals = number of tasks + idle slots
        return tasks.length + idleSlots;
    
    }
}