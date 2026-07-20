class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int rotate = k % (m*n);

        while(rotate > 0){
            int[][] temp = new int[m][n];

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){

                    if((i == (m-1)) && (j == (n-1))){
                        temp[0][0] = grid[m-1][n-1];
                    }else if(j == (n-1)){
                        temp[i+1][0] = grid[i][j];
                    }else{
                        temp[i][j+1] = grid[i][j];
                    }
                }
            }
            grid = temp;
            rotate--;
        }
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<m;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<n;j++){
                list.add(grid[i][j]);
            }
            res.add(list);
        }
        return res;
    }
}