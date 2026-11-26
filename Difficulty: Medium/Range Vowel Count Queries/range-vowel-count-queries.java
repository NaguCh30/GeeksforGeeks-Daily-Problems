class Solution {
    public ArrayList<Integer> countVowels(String s, int[][] queries) {
        // code here
        int len = s.length();
        int[] vowelCount = new int[len];
        int currVowels = 0;
        
        for (int i = 0; i < len; i++) {
            if (isVowel(s.charAt(i))) {
                currVowels++;
            }
            vowelCount[i] = currVowels;
        }
        
        int n = queries.length;
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int[] query = queries[i];
            if (query[0] == 0) {
                ans.add(vowelCount[query[1]]);
            } else {
                ans.add(vowelCount[query[1]] - vowelCount[query[0] - 1]);
            }
        }
        
        return ans;
    }
    
    private boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
            ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                return true;
            }
        
        return false;
    }
}