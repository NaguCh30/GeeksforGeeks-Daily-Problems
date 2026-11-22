class Solution {
    public int longestSubarrayDivK(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        int maxLength = 0;

        map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {

            prefixSum += arr[i];

            int remainder = prefixSum % k;

            if (remainder < 0) {
                remainder += k;
            }

            if (map.containsKey(remainder)) {

                int length = i - map.get(remainder);

                maxLength = Math.max(maxLength, length);

            } else {

                map.put(remainder, i);

            }
        }

        return maxLength;
    }
}
