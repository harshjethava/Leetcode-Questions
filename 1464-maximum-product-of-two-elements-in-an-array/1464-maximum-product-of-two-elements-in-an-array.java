class Solution {
    public int maxProduct(int[] nums) {

        int len = nums.length;
        int max1 = -1;
        int max2 = -1;

        for(int i=0;i<len;i++){
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }
        return (max1 - 1) * (max2 - 1);
        
    }
}