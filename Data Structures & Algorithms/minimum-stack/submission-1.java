class MinStack {

    Stack<Integer>st;
    Stack<Integer>auxSt;

    public MinStack() {
        st = new Stack<>();
        auxSt = new Stack<>();
    }
    
    public void push(int val) {
        int currMin = auxSt.empty()? val : Math.min(auxSt.peek(), val);
        st.push(val);
        auxSt.push(currMin);
        
    }
    
    public void pop() {
        st.pop();
        auxSt.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return auxSt.peek();
    }
}
