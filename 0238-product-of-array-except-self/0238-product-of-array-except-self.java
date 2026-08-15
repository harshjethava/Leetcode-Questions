class Solution {
    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;

        int[] prefix = new int[len];
        int[] suffix = new int[len];
        int[] res = new int[len];

        int i = 1, j = len - 2;
        prefix[0] = nums[0];
        suffix[len-1] = nums[len-1];

        while(i < len && j >= 0){
            prefix[i] = prefix[i-1] * nums[i];
            suffix[j] = suffix[j+1] * nums[j];
            i++;
            j--;
        }
        res[0] = suffix[1];
        res[len-1] = prefix[len-2];
        for(int k=1;k<len-1;k++){
            res[k] = prefix[k-1] * suffix[k+1];
        }
        return res;
        
    }
}