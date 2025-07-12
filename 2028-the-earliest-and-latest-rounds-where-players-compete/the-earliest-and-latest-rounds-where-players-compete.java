class Solution {
    Map<String, int[]> memo = new HashMap<>();

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        return dfs(buildList(n), firstPlayer, secondPlayer, 1);
    }

    private List<Integer> buildList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        return list;
    }

    private int[] dfs(List<Integer> players, int a, int b, int round) {
        if (players.size() <= 1) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

        String key = players.toString();
        if (memo.containsKey(key)) return memo.get(key);

        int n = players.size();
        int posA = players.indexOf(a);
        int posB = players.indexOf(b);

        if (posA + posB == n - 1) {
            return new int[]{round, round};
        }

        int minRound = Integer.MAX_VALUE;
        int maxRound = Integer.MIN_VALUE;

        // Generate all outcomes of this round
        List<List<Integer>> nextRounds = generateNextRounds(players);

        for (List<Integer> next : nextRounds) {
            if (next.contains(a) && next.contains(b)) {
                int[] res = dfs(next, a, b, round + 1);
                minRound = Math.min(minRound, res[0]);
                maxRound = Math.max(maxRound, res[1]);
            }
        }

        int[] result = new int[]{minRound, maxRound};
        memo.put(key, result);
        return result;
    }

    private List<List<Integer>> generateNextRounds(List<Integer> players) {
        List<List<Integer>> result = new ArrayList<>();
        generate(players, 0, new ArrayList<>(), result);
        return result;
    }

    private void generate(List<Integer> players, int i, List<Integer> temp, List<List<Integer>> result) {
        int n = players.size();
        if (i >= n / 2) {
            if (n % 2 == 1) temp.add(players.get(n / 2));
            List<Integer> nextRound = new ArrayList<>(temp);
            Collections.sort(nextRound);
            result.add(nextRound);
            if (n % 2 == 1) temp.remove(temp.size() - 1);
            return;
        }

        int left = players.get(i);
        int right = players.get(n - 1 - i);

        temp.add(left);
        generate(players, i + 1, temp, result);
        temp.remove(temp.size() - 1);

        temp.add(right);
        generate(players, i + 1, temp, result);
        temp.remove(temp.size() - 1);
    }
}