class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> freqMap = new HashMap<>();
        for(char c: s.toCharArray()){
            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = 
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(freqMap.entrySet());

        StringBuilder result  = new StringBuilder();
        while(!maxHeap.isEmpty()){
            Map.Entry<Character,Integer> entry = maxHeap.poll();
            char  c = entry.getKey();
            int freq = entry.getValue();
            for(int i = 0;i<freq;i++){
                result.append(c);
            }

        }
        return result.toString();
    }
}