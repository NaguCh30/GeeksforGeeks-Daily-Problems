class Solution {
    public void sortIt(int[] arr) {
        // code here
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        
        for(int num : arr) {
            if(num % 2 == 0) even.add(num);
            else odd.add(num);
        }
        
        Collections.sort(even);
        Collections.sort(odd);
        int last = odd.size() - 1;
        int idx = 0;
        while(last >= 0) {
            arr[idx++] = odd.get(last--);
        }
        int first = 0;
        while(first <= even.size() - 1) {
            arr[idx++] = even.get(first++);
        }
    }
}
