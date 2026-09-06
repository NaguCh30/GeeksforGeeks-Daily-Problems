class Solution {
    public ArrayList<String> matchingStrings(ArrayList<String> d, String pat) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        
        int patLength = pat.length();
        
        for (String string : d) {
            
            HashMap<Character, Character> map1 = new HashMap<>();
            HashMap<Character, Character> map2 = new HashMap<>();
            
            int len = string.length();
            if(len != patLength) {
                continue;
            }
            
            int i = 0;
            
            for(i = 0; i < len; i++) {
                
                char ch1 = string.charAt(i);
                char ch2 = pat.charAt(i);
                
                if (map1.containsKey(ch1)) {
                    
                    char value = map1.get(ch1);
                    if (value != ch2) {
                        break;
                    } else {
                        continue;
                    }
                }
                
                if (map2.containsKey(ch2)) {
                    
                    char value = map2.get(ch2);
                    if (value != ch1) {
                        break;
                    } else {
                        continue;
                    }
                }
                
                map1.put(ch1, ch2);
                map2.put(ch2, ch1);
            }
            
            if (i == len) {
                ans.add(string);
            }
        }
        
        return ans;
    }
}