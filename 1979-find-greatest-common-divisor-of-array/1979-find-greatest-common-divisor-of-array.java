class Solution {

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public int findGCD(int[] nums) {
        Arrays.sort(nums);

        return gcd(nums[0],nums[nums.length - 1]);
    }
}