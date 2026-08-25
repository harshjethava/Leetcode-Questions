class Solution {
    public int missingMultiple(int[] nums, int k) {
        
        int[] multiple = new int[101];
        for(int i=0;i<101;i++){
            multiple[i] = k * (i + 1);
        }
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<len;i++){
            list.add(nums[i]);
        }

        for(int i=0;i<101;i++){
            if(!list.contains(multiple[i])){
                return multiple[i];
            }
        }
        return 0;

    }
}