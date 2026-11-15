class Solution {
    public int subsequenceSum(String s) {

        long MOD = 1000000007;

        long sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum = (sum + (s.charAt(i) - '0')) % MOD;
        }

        long power = 1;

        for (int i = 1; i < s.length(); i++) {
            power = (power * 2) % MOD;
        }

        long ans = (sum * power) % MOD;

        return (int) ans;
    }
}