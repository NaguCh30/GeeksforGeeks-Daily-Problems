class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // code here
        int i = 0, j = 0;
        int m = a.length, n = b.length;
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while (i < m && j < n) {
            
            if (a[i] < b[j]) {
                
                if (result.isEmpty() || result.get(result.size() - 1) != a[i]) {
                    result.add(a[i]);
                }
                
                i++;
                
            } else if (b[j] < a[i]) {
                
                if (result.isEmpty() || result.get(result.size() - 1) != b[j]) {
                    result.add(b[j]);    
                }
                
                j++;
                
            } else {
                
                if (result.isEmpty() || result.get(result.size() - 1) != a[i]) {
                    result.add(a[i]);
                }
                
                i++;
                j++;
            }
        }
        
        while (i < m) {
            if (result.isEmpty() || result.get(result.size() - 1) != a[i]) {
                result.add(a[i]);
            }
            i++;
        }
        
        while (j < n) {
            if (result.isEmpty() || result.get(result.size() - 1) != b[j]) {
                result.add(b[j]);
            }
            j++;
        }
        
        return result;
    }
}
