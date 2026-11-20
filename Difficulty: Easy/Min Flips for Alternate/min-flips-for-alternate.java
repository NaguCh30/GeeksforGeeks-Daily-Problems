class Solution {
    public int minFlips(String s) {
        // code here
        int firstFlip = 0;
        int secondFlip = 0;
        
        for (int i = 0; i < s.length(); i++) {
            
            char expected1 = (i % 2 == 0) ? '0' : '1';
            char expected2 = (i % 2 == 0) ? '1' : '0';
            
            if (s.charAt(i) != expected1) {
                firstFlip++;
            }
            
            if (s.charAt(i) != expected2) {
                secondFlip++;
            }
        }
        
        return Math.min(firstFlip, secondFlip);
    }
}