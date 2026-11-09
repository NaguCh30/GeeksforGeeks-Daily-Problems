class Solution {
    int getCount(String s, int k) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        
        char prevChar = s.charAt(0);
        map.put(prevChar, 1);
        
        for (int i = 1; i < s.length(); i++) {
            char currChar = s.charAt(i);
            
            if (prevChar != currChar) {
                map.put(currChar, map.getOrDefault(currChar, 0) + 1);
                prevChar = currChar;
            }
        }
        
        int count = 0;
        
        for (int value : map.values()) {
            if (value == k) {
                count++;
            }
        }
        
        return count;
    }
}