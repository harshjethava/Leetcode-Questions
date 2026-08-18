class Solution {
    public int largestInteger(int[] nums, int k) {

        int len = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int temp = nums[0];
        if(len == k){
            for(int i=0;i<len;i++){
                temp = Math.max(temp,nums[i]);
            }
            return temp;
        }

        for(int i=0;i<=len-k;i++){
            for(int j=i;j<i+k;j++){
                map.put(nums[j],map.getOrDefault(nums[j], 0) + 1);
            }
        }

        int max = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if(value == 1){
                max = Math.max(max,key);
            }  
        }
        return max;
        
    }
}