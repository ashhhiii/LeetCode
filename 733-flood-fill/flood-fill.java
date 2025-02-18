class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor != color) {
            dfs(image, sr, sc, originalColor, color);
        }
        return image;
    }

    private void dfs(int[][] image, int x, int y, int originalColor, int newColor) {
        // Boundary check
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != originalColor) {
            return;
        }

        // Change the color
        image[x][y] = newColor;

        // Move in 4 directions (up, down, left, right)
        dfs(image, x + 1, y, originalColor, newColor);
        dfs(image, x - 1, y, originalColor, newColor);
        dfs(image, x, y + 1, originalColor, newColor);
        dfs(image, x, y - 1, originalColor, newColor);
    }
}