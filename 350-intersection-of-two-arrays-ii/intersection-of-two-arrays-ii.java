class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
         Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        
        // Populate frequency map with nums1
        for (int num : nums1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Check nums2 against the frequency map
        for (int num : nums2) {
            if (frequencyMap.containsKey(num) && frequencyMap.get(num) > 0) {
                resultList.add(num);
                frequencyMap.put(num, frequencyMap.get(num) - 1);
            }
        }
        
        // Convert the result list to an array
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        
        return result;
    }
}