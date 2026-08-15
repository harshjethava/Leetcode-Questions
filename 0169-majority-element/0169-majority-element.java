class Solution {
    public int majorityElement(int[] nums) {

        int len = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<len;i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0) + 1);

            if(map.get(nums[i]) > len/2) return nums[i];
        }
        return 0;
    }
}