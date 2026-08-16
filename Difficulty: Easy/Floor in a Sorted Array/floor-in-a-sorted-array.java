class Solution {
    static int findFloor(int[] arr, int x) {
        // code here
        int req = Integer.MIN_VALUE;
        int reqi = -1;
        for (int i = 0; i < arr.length; i++) {
            
            if (arr[i] >= req && arr[i] <= x) {
                req = arr[i];
                reqi = i;
            }
        }
        
        return reqi == -1 ? -1 : reqi;
    }
}
