class Solution {
    public int numTilePossibilities(String tiles) {
        // Step 1: Count the frequency of each character
        int[] count = new int[26];
        for (char c : tiles.toCharArray()) {
            count[c - 'A']++;
        }
        
        // Step 2: Begin the depth-first search tracking
        return dfs(count);
    }
    
    private int dfs(int[] count) {
        int sum = 0;
        
        // Try to place any available letter at the current position
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) continue; // Letter not available
            
            // Choose the character
            sum++; // Every choice made represents a unique, valid non-empty sequence
            count[i]--; // Reduce its available count
            
            // Move deeper into the recursion to pick the next letter
            sum += dfs(count);
            
            // Backtrack: Restore the letter count for other paths
            count[i]++;
        }
        
        return sum;
    }
}
