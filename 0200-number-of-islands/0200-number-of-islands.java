class Solution {
    public static void dfs(int i, int j, boolean[][] vis, char[][] grid, int m, int n){
        
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1' || vis[i][j]){
            return;
        }

        vis[i][j] = true;

        dfs(i-1, j, vis, grid, m, n); //top
        dfs(i+1, j, vis, grid, m, n); //bottom
        dfs(i, j-1, vis, grid, m, n); //left
        dfs(i, j+1, vis, grid, m, n); //right

    }
    public int numIslands(char[][] grid) { // solve using DFS
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;
        boolean[][] vis = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    dfs(i, j, vis, grid, m, n);
                    islands++;
                }
            }
        }
        return islands;
    }
}