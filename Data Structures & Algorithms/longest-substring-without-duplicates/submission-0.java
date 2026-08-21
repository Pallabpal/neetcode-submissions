class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> charSet = new HashSet<>();

        int l =0;
        int res =0;
        for(int r =0; r<s.length(); r++){
            char ch = s.charAt(r);
            while(charSet.contains(ch)){
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(ch);
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
