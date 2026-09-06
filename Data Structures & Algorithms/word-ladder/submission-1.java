class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        Queue<String> q = new LinkedList<>();
        Set<String> st = new HashSet<>();

        for(String word : wordList){
            st.add(word);
        }
        int steps = 1;
        if(!st.contains(endWord)) return 0;
        
        q.offer(beginWord);


        while(!q.isEmpty()){
            int sz = q.size();
            for(int k =0; k<sz; k++){
                String current = q.poll();

            if(current.equals(endWord)){
                return steps;
            }
            
            StringBuilder word = new StringBuilder(current);
            for(int i=0; i<current.length(); i++){
               for(char c ='a'; c<='z'; c++){
                  word.setCharAt(i, c);
                  if(st.contains(word.toString())){
                    st.remove(word.toString());
                    q.offer(word.toString());
                  }
              }
               word = new StringBuilder(current);
              }
            }
           
            steps++;
        }
        return 0;
        
    }
}
