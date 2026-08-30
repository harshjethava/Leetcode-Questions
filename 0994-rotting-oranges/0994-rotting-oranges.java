class Solution { 
    public int orangesRotting(int[][] grid) { // solve using BFS

        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j, 0});
                }
            }
        }

        while(queue.size() > 0){

            int curr[] = queue.poll();
            int i = curr[0];
            int j = curr[1];
            int time = curr[2];

            ans = Math.max(ans,time);

            if(i-1 >= 0 && !visited[i-1][j] && grid[i-1][j] == 1){ // top
                queue.add(new int[]{i-1, j, time + 1});
                visited[i-1][j] = true;
            }
            
            if(i+1 < m && !visited[i+1][j] && grid[i+1][j] == 1){ // bottom
                queue.add(new int[]{i+1, j, time + 1});
                visited[i+1][j] = true;
            }

            if(j-1 >= 0 && !visited[i][j-1] && grid[i][j-1] == 1){ // left
                queue.add(new int[]{i, j-1, time + 1});
                visited[i][j-1] = true;
            }

            if(j+1 < n && !visited[i][j+1] && grid[i][j+1] == 1){ // right
                queue.add(new int[]{i, j+1, time + 1});
                visited[i][j+1] = true;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    return -1;
                }
            }
        }
        return ans;
        
    }
}