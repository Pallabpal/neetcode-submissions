class Solution {
    public String decodeString(String s) {
        
        int n = s.length();
        String temp ="";

        Stack<Integer>numStack = new Stack<>();
        Stack<Character>charStack = new Stack<>();

        for(int i =0; i<n;i++){
          int cnt =0;


           if(Character.isDigit(s.charAt(i))){
              while(Character.isDigit(s.charAt(i))){
                 cnt = cnt *10 + (s.charAt(i) - '0');
                 i++;
              }
              i--;
               numStack.push(cnt);
           }
        else if(s.charAt(i) != ']'){
          charStack.push(s.charAt(i));
        }else{
          cnt = numStack.pop();
          temp = "";
          while(charStack.peek() != '['){
            temp = charStack.pop() + temp;
          }
          charStack.pop();

          StringBuilder repeated = new StringBuilder();

          for(int k =0; k<cnt ; k++){
            repeated.append(temp);
          }
          
          for(int k =0; k<repeated.length(); k++){
            charStack.push(repeated.charAt(k));
          }
        }

        }

        StringBuilder st = new StringBuilder();

        while(!charStack.isEmpty()){
          st.append(charStack.pop());
        }

        st.reverse();

        return st.toString();
    }
    
}