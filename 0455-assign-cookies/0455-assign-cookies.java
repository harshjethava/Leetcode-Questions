class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        Arrays.sort(g);
        Arrays.sort(s);

        int len1 = g.length;
        int len2 = s.length;

        int i = 0, j = 0;
        int res = 0;

        while(i < len1 && j < len2){
            if(s[j] >= g[i]){
                res++;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return res;

    }
}