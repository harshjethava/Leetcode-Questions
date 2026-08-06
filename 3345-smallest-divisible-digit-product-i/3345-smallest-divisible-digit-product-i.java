class Solution {

    public int cal(int data){
        int res = 1;
        while(data > 0){
            int rem = data % 10;
            res = res * rem;
            data = data / 10;
        }
        return res;

    }

    public int smallestNumber(int n, int t) {

        if((cal(n) % t) == 0) return n;
        int temp = n;
        while(true){
            int res = cal(temp);
            if(res % t == 0) return temp;
            else temp++; 
        }
        // return null;
    }
}