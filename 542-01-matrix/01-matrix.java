class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist =  new int[m][n];
        Queue <int[]> queue = new LinkedList<>();

        for (int i = 0; i< m ; i++){
            for( int j= 0; j < n ; j++){
                if (mat[i][j] == 0){
                    dist[i][j] = 0;
                    queue.add(new int[]{i , j});
                }else {
                    dist[i][j] = Integer.MAX_VALUE;

                }
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c= curr[1];

            for (int[] dir : directions){
                int newR =  r + dir[0];
                int newC = c + dir[1];

                if (newR >= 0 && newR < m && newC >= 0 && newC < n) {
                    if( dist[newR][newC] > dist[r][c] + 1){
                        dist[newR][newC] = dist[r][c] + 1;
                        queue.add(new int[]{ newR , newC});
                    }
                }
            }
        }
        return dist;
            
                    
    }
}