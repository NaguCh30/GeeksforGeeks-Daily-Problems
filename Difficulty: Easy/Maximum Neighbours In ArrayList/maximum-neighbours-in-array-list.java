class Solution {
    public static ArrayList<Integer> maxNeighbour(ArrayList<Integer> arr) {
        // code here
        int first = arr.get(0);
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int i = 1; i < arr.size(); i++) {
            
            ans.add(Math.max(first, arr.get(i)));
            first = arr.get(i);
        }
        
        return ans;
    }
}