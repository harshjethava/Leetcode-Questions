class Solution {

    void dfs(int i, int j, int[][] image, int m, int n, int original, int newColor){

        if(i < 0 || j < 0 || i >= m || j >= n || image[i][j] != original || image[i][j] == newColor){
            return;
        }
        
        image[i][j] = newColor;
        dfs(i-1, j, image, m, n, original, newColor); // Top
        dfs(i, j+1, image, m, n, original, newColor); // Right
        dfs(i+1, j, image, m, n, original, newColor); // Bottom
        dfs(i, j-1, image, m, n, original, newColor); // Left

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int m = image.length;
        int n = image[0].length;

        dfs(sr, sc, image, m, n, image[sr][sc], color);
        return image;

    }
}