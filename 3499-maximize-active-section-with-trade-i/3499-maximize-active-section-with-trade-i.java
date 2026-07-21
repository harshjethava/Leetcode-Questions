class Solution {
    public int maxActiveSectionsAfterTrade(String str) {
        int len = str.length();
        int activeCount = 0; 
        int count = 0; 
        
        for (char ch : str.toCharArray()) {
            if (ch == '1') {
                count++;
            }
        }
        
        List<Integer> blks = new ArrayList<>();
        int idx = 0;
        
        while (idx < len) {
            int pos = idx;
            
            while (idx < len && str.charAt(idx) == str.charAt(pos)) {
                idx++;
            }
            
            if (str.charAt(pos) == '0') {
                blks.add(idx - pos);
            }
        }
        
        int size = blks.size();
        
        if (size < 2) {
            return count;
        }
        
        int gain = 0;
        
        for (int i = 0; i < size - 1; i++) {
            int cur = blks.get(i) + blks.get(i + 1);
            gain = Math.max(gain, cur);
        }
        
        return count + gain;
    }
}