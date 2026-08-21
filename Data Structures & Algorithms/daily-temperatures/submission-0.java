class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        Stack<int[]> st = new Stack<>();
        int[] results = new int[n];
        results[n-1] = 0;
        st.push(new int[]{temperatures[n-1], n-1});
        for(int i=n-2; i>=0; i--){
            int curr = temperatures[i];
            while(!st.isEmpty() && curr>=st.peek()[0]){
                st.pop();
            }
            results[i] = st.isEmpty() ?  0 : st.peek()[1] - i; 

            st.push(new int[]{curr, i});
        
        }
        return results;
    }
}
