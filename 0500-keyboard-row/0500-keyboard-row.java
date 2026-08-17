import java.util.*;

class Solution {
    public String[] findWords(String[] words) {
        HashSet<Character> topRow = new HashSet<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
        HashSet<Character> middleRow = new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l'));
        HashSet<Character> bottomRow = new HashSet<>(Arrays.asList('z','x','c','v','b','n','m'));
        List<String> result = new ArrayList<>();
        
        for(String word : words){
            String lower = word.toLowerCase();
            char first = lower.charAt(0);

            HashSet<Character> currentSet;
            if(topRow.contains(first)){
                currentSet = topRow;
            }else if(middleRow.contains(first)){
                currentSet = middleRow;
            }else{
                currentSet = bottomRow;
            }

            boolean isValid = true;
            for(int i=1; i<lower.length(); i++){
                if(!currentSet.contains(lower.charAt(i))){
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }
}
