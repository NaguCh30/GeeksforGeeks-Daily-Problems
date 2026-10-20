
import java.util.*;

class Solution {
    public ArrayList<Integer> lexicographicallyLargest(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

        int i = 0;

        while (i < n) {
            int j = i;

            // Find the contiguous group with the same parity
            while (j < n && arr[j] % 2 == arr[i] % 2) {
                j++;
            }

            // Copy this group into a list
            ArrayList<Integer> group = new ArrayList<>();
            for (int k = i; k < j; k++) {
                group.add(arr[k]);
            }

            // Sort the group in descending order
            group.sort(Collections.reverseOrder());

            // Add the sorted group to the result
            result.addAll(group);

            i = j;
        }

        return result;
    }
}
