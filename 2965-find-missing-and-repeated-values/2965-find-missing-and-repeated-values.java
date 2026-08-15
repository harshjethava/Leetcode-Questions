class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        int[] res = new int[2];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int curr = grid[i][j]; 
                map.put(curr, map.getOrDefault(curr , 0) + 1);
                set.add(curr);
                if(map.get(curr) > 1){
                    res[0] = curr;
                }
            }
        }
        
        for(int i=1;i<=m*n;i++){
            if(!set.contains(i)){
                res[1] = i;
                break;
            }
        }
        return res;

    }
}