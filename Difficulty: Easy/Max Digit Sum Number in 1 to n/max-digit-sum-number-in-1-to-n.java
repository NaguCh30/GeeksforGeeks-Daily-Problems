class Solution {
    public int findMax(int n) {
        String s = String.valueOf(n);
        int ans = n;
        int maxSum = digitSum(n);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') continue;

            StringBuilder temp = new StringBuilder(s);
            temp.setCharAt(i, (char)(temp.charAt(i) - 1));

            for (int j = i + 1; j < temp.length(); j++) {
                temp.setCharAt(j, '9');
            }

            int num = Integer.parseInt(temp.toString());
            int sum = digitSum(num);

            if (sum > maxSum || (sum == maxSum && num > ans)) {
                maxSum = sum;
                ans = num;
            }
        }

        return ans;
    }

    private int digitSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}