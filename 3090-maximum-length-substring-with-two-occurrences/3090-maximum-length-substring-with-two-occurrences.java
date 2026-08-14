class Solution {
    public int maximumLengthSubstring(String s) {
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, max = 0;

        for (int j = 0; j < len; j++) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.get(ch) > 2) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
