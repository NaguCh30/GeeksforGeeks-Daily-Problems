class Solution {
    public static int kthLargest(int[] arr, int k) {
        // code here
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                maxHeap.add(sum);
            }
        }
        
        while (k-- > 1) {
            maxHeap.poll();
        }
        
        return maxHeap.poll();
    }
}
