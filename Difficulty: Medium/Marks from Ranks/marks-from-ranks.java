class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        // code here
        int min = l[0];
        int max = r[r.length - 1];
        
        ArrayList<Integer> marks = new ArrayList<>();
        int len = l.length;
        
        for (int i = 0; i < len; i++) {
            int left = l[i];
            int right = r[i];
            
            for (int j = left; j <= right; j++) {
                marks.add(j);
            }
        }
        
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < rank.length; i++) {
            output.add(marks.get(rank[i] - 1));
        }
        
        return output;
    }
}