class Solution {
    public int stoneGameVIII(int[] stones) {
        int len = stones.length;
        int prefix[] = new int[len];
        prefix[0] = stones[0];
        for(int i=1;i<len;i++){
            prefix[i] = prefix[i-1] + stones[i];
        }

        int diff = prefix[len-1];

        for(int i=len - 2; i >= 1; i--){
            diff = Math.max(diff,prefix[i] - diff);
        }
        return diff;
    }
}