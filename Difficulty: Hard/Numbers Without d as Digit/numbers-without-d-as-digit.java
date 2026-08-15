class Solution {
     public int countWithout(int n, int d) {
         if (n == 0) return 0;
         
         String s = Integer.toString(n);
         int L = s.length();
         long count = 0;

         for (int k = 1; k < L; k++) {
             long firstChoices = (d == 0) ? 9 : 8;
             long otherChoices = 1;
             for (int j = 0; j < k - 1; j++) {
                 otherChoices *= 9;
             }
             count += firstChoices * otherChoices;
         }

         boolean broke = false;
         for (int i = 0; i < L; i++) {
             int curDigit = s.charAt(i) - '0';
             int start = (i == 0) ? 1 : 0; 

             for (int dd = start; dd < curDigit; dd++) {
                 if (dd == d) continue;
                 long pow = 1;
                 for (int j = 0; j < L - 1 - i; j++) pow *= 9;
                 count += pow;
             }

             if (curDigit == d) {
                 broke = true;
                 break;
             }
         }

         if (!broke) count += 1;

         return (int) count;
     }
 }