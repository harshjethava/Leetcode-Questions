class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<len;i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
            list.add(nums[i]);
        }

        List<Integer> res = new ArrayList<>();
        for(int i=min;i<=max;i++){
            if(!list.contains(i)){
                res.add(i);
            }
        }
        Collections.sort(res);
        return res;
        
    }
}