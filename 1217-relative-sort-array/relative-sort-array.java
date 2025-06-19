class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
         Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Add elements from arr2 to the result array in order
        List<Integer> result = new ArrayList<>();
        for (int num : arr2) {
            int count = frequencyMap.get(num);
            for (int i = 0; i < count; i++) {
                result.add(num);
            }
            frequencyMap.remove(num); // Remove processed elements
        }

        // Step 3: Add remaining elements from arr1 not in arr2
        List<Integer> remaining = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                remaining.add(num);
            }
        }

        // Sort remaining elements
        Collections.sort(remaining);

        // Combine results
        result.addAll(remaining);

        // Convert to int array
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}