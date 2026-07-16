class Solution {

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
    public long gcdSum(int[] nums) {

        long max = nums[0];
        int len = nums.length;
        long[] prefixGcd = new long[len];
        prefixGcd[0] = nums[0];
        for(int i=1;i<len;i++){
            max = Math.max(max, nums[i]);

            prefixGcd[i] = gcd(nums[i],max);
        }
        
        Arrays.sort(prefixGcd);

        long sum = 0;
        int i=0,j=len-1;

        while(i < j){
            long temp = gcd(prefixGcd[i],prefixGcd[j]);
            sum = sum + temp;
            i++;
            j--;
        }
        return sum;
    }
}