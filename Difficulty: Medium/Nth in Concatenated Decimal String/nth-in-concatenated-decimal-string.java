class Solution {
    public char nthCharacter(int n) {
        int digits = 1;
        long count = 9;
        long start = 1;

        // Find the group of numbers containing the nth character
        while (n > digits * count) {
            n -= (int) (digits * count);
            digits++;
            count *= 10;
            start *= 10;
        }

        // Find the number containing the nth character
        long number = start + (n - 1) / digits;

        // Find the character within that number
        int index = (n - 1) % digits;

        return String.valueOf(number).charAt(index);
    }
}