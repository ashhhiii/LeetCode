class Solution {
    public int numberOfPairs(int[][] points) {
         int n = points.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int ax = points[i][0];
            int ay = points[i][1];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int bx = points[j][0];
                int by = points[j][1];

                if (ax > bx || ay < by) continue;

                boolean ok = true;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    int px = points[k][0];
                    int py = points[k][1];
                    if (ax <= px && px <= bx && by <= py && py <= ay) {
                        ok = false;
                        break;
                    }
                }
                if (ok) ans++;
            }
        }

        return ans;
    }
}