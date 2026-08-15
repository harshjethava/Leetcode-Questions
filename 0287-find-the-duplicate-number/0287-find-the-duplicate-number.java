class Solution {
    public int findDuplicate(int[] nums) {

        // Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        for(int i=0;i<len;i++){
            int curr = nums[i];
            map.put(curr, map.getOrDefault(curr , 0) + 1);
            if(map.get(curr) > 1) return nums[i];
        }
        return 0;
        
    }
}