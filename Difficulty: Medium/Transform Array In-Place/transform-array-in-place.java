class Solution {
    public void arrange(int[] arr) {
        // code here
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] + (arr[arr[i] % n] % n) * n;
        }
        
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / n;
        }
    }
}