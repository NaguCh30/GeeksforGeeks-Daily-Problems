class Solution {
    public ArrayList<ArrayList<Integer>> mergeOverlap(int[][] arr) {
        // Code here
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(arr, (a, b) ->
                Integer.compare(a[0], b[0])
            );
        
        int n = arr.length;
        int i = 0;
        
        while (i < n) {
            
            int start = arr[i][0];
            int end = arr[i][1];
            
            while(i < n && arr[i][0] <= end) {
                end = Math.max(end, arr[i][1]);
                i++;
            }
            
            ArrayList<Integer> interval = new ArrayList<>();
            interval.add(start);
            interval.add(end);
            ans.add(interval);
        }
        
        return ans;
    }
}