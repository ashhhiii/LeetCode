class Solution {
    public long minCost(int[] basket1, int[] basket2) {

        Map<Integer, Integer> count = new TreeMap<>();
        int n = basket1.length;

        // Count all elements in both baskets
        for (int i = 0; i < n; i++) {
            count.put(basket1[i], count.getOrDefault(basket1[i], 0) + 1);
            count.put(basket2[i], count.getOrDefault(basket2[i], 0) - 1);
        }

        // Check for impossibility
        List<Integer> toSwap = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int val = entry.getValue();
            if (val % 2 != 0) return -1; // odd mismatch - not fixable

            // We only care about surplus elements in basket1
            for (int i = 0; i < Math.abs(val) / 2; i++) {
                toSwap.add(entry.getKey());
            }
        }

        Collections.sort(toSwap);

        long minValue = Collections.min(Arrays.asList(Arrays.stream(basket1).min().getAsInt(), Arrays.stream(basket2).min().getAsInt()));
        long cost = 0;

        // Only need to process half the swaps, rest are matched
        for (int i = 0; i < toSwap.size() / 2; i++) {
            cost += Math.min(toSwap.get(i), 2 * minValue);
        }

        return cost;
    }
}

