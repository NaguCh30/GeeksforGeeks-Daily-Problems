class Solution {
    public int minProd(int[] arr) {
        // code here
        int negativeCount = 0;
        int zeroCount = 0;
        int negCloseToZero = Integer.MIN_VALUE;
        int product = 1;
        
        for (int x : arr) {
            if (x == 0) {
                zeroCount++;
            } else if (x < 0) {
                negativeCount++;
                negCloseToZero = Math.max(negCloseToZero, x);
                product *= x;
            }
        }
        
        if (negativeCount == 0) {
            if (zeroCount > 0) {
                return 0;
            }
            
            
            int min = arr[0];
            for (int x : arr) {
                if (x < min) {
                    min = x;
                }
            }
            
            return min;
        }
        
        if (negativeCount % 2 == 0) {
            product /= negCloseToZero;
        }
        
        for (int x : arr) {
            if (x > 1) {
                product *= x;
            }
        }
        
        return product;
    }
}