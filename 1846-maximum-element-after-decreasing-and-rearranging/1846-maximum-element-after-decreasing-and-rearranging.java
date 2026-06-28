class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        Arrays.sort(arr);
        int len = arr.length;
        if(arr[0] != 1) arr[0] = 1;

        for(int i=1;i<len;i++){

            int prev = arr[i-1];
            int curr = arr[i];
            int abs = Math.abs(curr - prev);

            if(abs > 1){
                arr[i] = arr[i-1] + 1;
            }

        }
        return arr[len-1];
    }
}