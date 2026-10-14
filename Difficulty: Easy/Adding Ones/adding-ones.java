class Solution {
    public ArrayList<Integer> update(int n, int[] updates) {
        // code here
        int[] freq = new int[n];
        
        for (int elem : updates) {
            freq[elem - 1]++;
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            count += freq[i];
            arr.add(count);
        }
        
        return arr;
    }
}