class Solution {
    public boolean findPattern(String s) {
        // code here
        int xCount = 0;
        int yCount = 0;
        
        for (char ch : s.toCharArray()) {
            
            if (ch == 'x') {
                
                if (yCount > 0) {
                    return false;
                }
                
                xCount++;
                
            } else if (ch == 'y') {
                
                yCount++;
                
                if (yCount > xCount) {
                    return false;
                }
            }
            
            if (xCount == yCount && xCount > 0) {
                xCount = 0;
                yCount = 0;
            }
        }
        
        return xCount == 0 && yCount ==0;
    }
}
