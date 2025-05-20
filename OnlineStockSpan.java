package interviewQA.StackAndQueues;

import java.util.Stack;

public class OnlineStockSpan {
    Stack<Integer> st;
    Stack<Integer> span;

    public OnlineStockSpan() {
        st = new Stack<>();
        span = new Stack<>();
    }

    public int next(int price) {
        int days = 1;
        while(!st.isEmpty() && st.peek() <= price){
            st.pop();
            days = days + span.pop();
        }
        st.push(price);
        span.push(days);
        return days;
    }
}



