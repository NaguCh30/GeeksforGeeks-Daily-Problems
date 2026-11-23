class Solution {
    public char posInfinite(String s, int pos) {

        long len = s.length();
        List<Long> lengths = new ArrayList<>();

        lengths.add(len);

        while (len < pos) {
            len = 2 * len + lengths.size();
            lengths.add(len);
        }

        for (int i = lengths.size() - 1; i > 0; i--) {

            long previousLen = lengths.get(i - 1);
            long separatorLen = i;

            if (pos <= previousLen) {
                continue;
            }

            if (pos <= previousLen + separatorLen) {
                return '$';
            }

            pos = (int) (2 * previousLen + separatorLen - pos + 1);
        }

       return s.charAt(pos - 1);
    }
}