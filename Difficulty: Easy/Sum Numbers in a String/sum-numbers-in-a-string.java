class Solution {
    public static int findSum(String s) {
        // code here
        int sum = 0;
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
            
            char ch = s.charAt(i);
            if (Character.isDigit(ch)){
                StringBuilder sb = new StringBuilder();
                
                while(i < len && Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
                
                sum += Integer.parseInt(sb.toString());
            }
        }
        
        return sum;
    }
}