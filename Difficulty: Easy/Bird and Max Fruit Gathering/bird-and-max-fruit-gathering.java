class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        // code here
        int n = arr.size();
        int sum = 0;
        
        for (int i = 0; i < m; i++) {
            sum += arr.get(i);
        }
        
        int maxSum = sum;
        
        for (int start = 1; start < n; start++) {
            sum -= arr.get(start - 1);
            int next = (start + m - 1) % n;
            sum += arr.get(next);
            
            maxSum = Math.max(sum, maxSum);
        }
        
        return maxSum;
    }
}