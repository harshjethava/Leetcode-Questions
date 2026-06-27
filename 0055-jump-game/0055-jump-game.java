class Solution {
    public boolean canJump(int[] nums) {

        int len = nums.length;
        int maxL = 0;

        for(int i=0;i<len;i++){

            if(i > maxL) return false;

            maxL = Math.max(maxL, i + nums[i]);
            if(maxL >= len - 1) return true;
        }
        return true;
        
    }
}