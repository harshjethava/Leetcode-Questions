class Solution {
    public int maxDepth(String s) {

        int left = 0;
        int ans = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                left++;
                ans = Math.max(ans,left);
            }else if(ch == ')'){
                left--;
            }
        }
        return ans;
    }
}