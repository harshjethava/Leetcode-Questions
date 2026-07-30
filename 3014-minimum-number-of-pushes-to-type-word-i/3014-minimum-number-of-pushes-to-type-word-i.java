class Solution {
    public int minimumPushes(String word) {

        int len = word.length();
        int res = 0;

        if(len <= 8) return len;

        if(len <= 16){
            int temp = (len - 8) * 2;
            res = res + 8 + temp;
        }else if(len <= 24){
            int temp = (len - 16) * 3;
            res = res + 24 + temp;
        }else{
            int temp = (len - 24) * 4;
            res = res + 48 + temp;
        }

        return res;

    }
}