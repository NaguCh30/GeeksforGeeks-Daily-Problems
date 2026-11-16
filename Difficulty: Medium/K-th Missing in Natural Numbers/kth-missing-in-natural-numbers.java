class Solution {
    public int findKthSmall(int[] arr, int k) {

        Arrays.sort(arr);

        int missing = k;

        for (int num : arr) {

            if (num <= missing) {
                missing++;
            } else {
                break;
            }
        }

        return missing;
    }
}