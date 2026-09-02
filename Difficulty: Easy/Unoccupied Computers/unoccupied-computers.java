class Solution {
    public int solve(int n, String s) {
        // code here
        int[] people = new int[26];
        int notGet = 0, len = s.length();
        
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            
            if (n == 0 && people[ch - 'A'] == 0) {
                notGet++;
                people[ch - 'A'] = -1;
                continue;
            }
            
            if (people[ch - 'A'] == 1) {
                people[ch - 'A']--;
                n++;
            } else {
                if (people[ch - 'A'] != -1) {
                    people[ch - 'A']++;
                    n--;
                }
            }
        }
        
        return notGet;
    }
}
