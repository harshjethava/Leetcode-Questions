class Solution {
    public List<Integer> partitionLabels(String s) {

        List<Integer> list = new ArrayList<>();
        
        int[] lastIndices = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndices[s.charAt(i) - 'a'] = i;
        }
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {

            end = Math.max(end, lastIndices[s.charAt(i) - 'a']);
            
            if (i == end) {
                list.add(end - start + 1);
                start = i + 1; // Move the start of the next partition
            }
        }
        
        return list;
        
    }
}