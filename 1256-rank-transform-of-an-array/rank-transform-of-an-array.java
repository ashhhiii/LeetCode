
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // Step 1: Create a sorted copy of the array
        int[] sortedArray = arr.clone();
        Arrays.sort(sortedArray);

        // Step 2: Assign ranks using a map
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int num : sortedArray) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
                rank++;
            }
        }

        // Step 3: Replace elements in the original array with their ranks
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }
}