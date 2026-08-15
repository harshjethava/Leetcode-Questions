class Solution {
    public int findDuplicate(int[] nums) {

        Arrays.sort(nums);
        int len = nums.length;
        for(int i=1;i<len;i++){
            if(nums[i-1] == nums[i]) return nums[i];
        }
        return 0;
        
    }
}