class Solution {

    private int xorTill(int n) {

        if (n % 4 == 0) {
            return n;
        }

        if (n % 4 == 1) {
            return 1;
        }

        if (n % 4 == 2) {
            return n + 1;
        }

        return 0;
    }

    public int findXOR(int l, int r) {

        return xorTill(r) ^ xorTill(l - 1);
    }
}
