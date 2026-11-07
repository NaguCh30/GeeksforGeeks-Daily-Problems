class Solution {
    public ArrayList<String> generateUsernames(String[] arr) {
        // code here
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : arr) {
            map.put(str, 0);
        }
        
        ArrayList<String> result = new ArrayList<>();
        
        for (String str : arr) {
            StringBuilder sb = new StringBuilder(str);
            
            if(map.get(str) != 0) {
            
                sb.append(map.get(str));
            
                while (map.containsKey(sb.toString())) {
            
                    map.put(str, map.get(str) + 1);
                    StringBuilder sb2 = new StringBuilder(str);
                    sb2.append(map.get(str));
                    sb = sb2;
            
                }
            }
            
            result.add(sb.toString());
            map.put(str, map.get(str) + 1);
        }
        
        return result;
    }
}