class Solution {
    int maxLength(int arr[]) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int prefixSum = 0;
        int maxLen = 0;
        
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            
            // if (prefixSum == 0) {
            //     maxLength = i + 1;
            // }
            
            if (map.containsKey(prefixSum)) {
                int len = i - map.get(prefixSum);
                maxLen = Math.max(len, maxLen);
            } else {
                map.put(prefixSum, i);
            }
        }
        
        return maxLen;
    }
}