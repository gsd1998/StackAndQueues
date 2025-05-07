package interviewQA.StackAndQueues;

import java.util.Stack;

class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class MinStack {
    Stack<Pair> st;
    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        if(st.isEmpty()){
            st.push(new Pair(val,val));
        }else{
            st.push(new Pair(val,Math.min(val,st.peek().y)));
        }
    }

    public void pop() {
        st.pop();

    }

    public int top() {
        return st.peek().x;
    }

    public int getMin() {
        return st.peek().y;
    }
}
