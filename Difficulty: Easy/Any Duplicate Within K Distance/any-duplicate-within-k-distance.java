class Solution {
    public boolean checkWithinK(int[] arr, int k) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            int elem = arr[i];
            
            if (!map.containsKey(elem)) {
                map.put(elem, i);
            } else {
                int j = map.get(elem);
                if (Math.abs(i - j) <= k) {
                    return true;
                }
                map.put(elem, i);
            }
        }
        
        return false;
    }
}