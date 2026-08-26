class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        // Collect indices of all '1's
        List<Integer> ones = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones.add(i);
            }
        }

        // If there are fewer than k '1's, it's impossible
        if (ones.size() < k) {
            return "";
        }

        String result = "";
        int minLength = Integer.MAX_VALUE;

        // Slide a window of size k over the list of indices
        for (int i = 0; i <= ones.size() - k; i++) {
            int start = ones.get(i);
            int end = ones.get(i + k - 1);
            String substring = s.substring(start, end + 1);

            // Compare length and lexicographical order
            if (substring.length() < minLength) {
                minLength = substring.length();
                result = substring;
            } else if (substring.length() == minLength) {
                if (substring.compareTo(result) < 0) {
                    result = substring;
                }
            }
        }

        return result;
        
        
    }
}