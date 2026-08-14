class Solution {
    int maxProduct(int[] arr) {
        // code here
        
        int maxEnding = arr[0];
        int minEnding = arr[0];
        int answer = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            
            int x = arr[i];
            int oldMax = maxEnding;
            int oldMin = minEnding;
            
            maxEnding = Math.max(
                    x,
                    Math.max(x * oldMax, x * oldMin)
                );
            
            minEnding = Math.min(
                    x, 
                    Math.min(x * oldMax, x * oldMin)
                );
            
            answer = Math.max(answer, maxEnding);
        }
        
        return answer;
    }
}