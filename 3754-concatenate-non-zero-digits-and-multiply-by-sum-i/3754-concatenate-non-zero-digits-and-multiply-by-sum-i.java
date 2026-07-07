class Solution {
    public long sumAndMultiply(int n) {

        long sum = 0;
        long temp = 0;


        while(n > 0){
            int rem = n % 10;
            n = n / 10;
            if(rem != 0) temp = (temp * 10) + rem;
            sum = sum + rem; 
        }

        long res = 0;
        while(temp > 0){
            long rem = temp % 10;
            temp = temp / 10;
            res = (res * 10) + rem;
        }
        return res * sum;
        
    }
}