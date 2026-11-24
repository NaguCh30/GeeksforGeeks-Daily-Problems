class Solution {
    public ArrayList<Integer> findPairs(int[] arr) {

        HashMap<Long, int[]> map = new HashMap<>();

        int n = arr.length;

        int[] ans = {-1, -1, -1, -1};

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                long sum = (long) arr[i] + arr[j];

                if (map.containsKey(sum)) {

                    int[] pair = map.get(sum);

                    int p = pair[0];
                    int q = pair[1];

                    // Check four distinct indices
                    if (p != i && p != j && q != i && q != j) {

                        int[] candidate = {p, q, i, j};

                        // Find lexicographically smaller quadruplet
                        boolean smaller = false;

                        if (ans[0] == -1) {
                            smaller = true;
                        } else {
                            for (int k = 0; k < 4; k++) {

                                if (candidate[k] < ans[k]) {
                                    smaller = true;
                                    break;
                                }

                                if (candidate[k] > ans[k]) {
                                    break;
                                }
                            }
                        }

                        if (smaller) {
                            ans = candidate;
                        }
                    }

                } else {

                    // Store only the first pair for this sum
                    map.put(sum, new int[]{i, j});
                }
            }
        }

        return new ArrayList<>(
            Arrays.asList(ans[0], ans[1], ans[2], ans[3])
        );
    }
}
