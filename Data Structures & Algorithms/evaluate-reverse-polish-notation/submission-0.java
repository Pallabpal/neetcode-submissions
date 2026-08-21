class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>();
        for(String ele : tokens){
             
             if(ele.equals("+")){
                st.push(st.pop() + st.pop());
             }
             else if(ele.equals("*")){
                st.push(st.pop() * st.pop());
             }else if(ele.equals("-")){
               int a = st.pop();
               int b = st.pop();
               st.push(b-a);
             }else if(ele.equals("/")){
                int a = st.pop();
                int b = st.pop();
                 st.push(b/a);
             }else{
                st.push(Integer.parseInt(ele));
             }
        }

        return st.pop();
    }
}
