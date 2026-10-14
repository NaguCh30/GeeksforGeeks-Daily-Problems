class Solution {
    public int minSquares(int n, int m) {
        // code here
        int count = 0;
        
        while (n > 0 && m > 0) {
            if (n < m) {
                int temp = n;
                n = m;
                m = temp;
            }
            
            count += n / m;
            n = n % m;
        }
        
        return count;
    }
}