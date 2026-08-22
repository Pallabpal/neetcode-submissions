class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();

        for(char c: s1.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        
        int have = 0, need = countT.size();
        int l = 0;
        for(int i =0; i<s2.length(); i++){
            char ch = s2.charAt(i);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if(countT.containsKey(ch) && countT.get(ch).equals(window.get(ch))){
                have ++;
            }
            
            while(i-l+1>s1.length()){
            char leftChar = s2.charAt(l);                
               if(countT.containsKey(leftChar) && window.get(leftChar).equals(countT.get(leftChar))){
                 have --;
               }
               window.put(leftChar, window.get(leftChar) -1);
               
               
               l++;
            } 

            if(need == have){
                return true;
            }
        }
        return false;
    }
}
