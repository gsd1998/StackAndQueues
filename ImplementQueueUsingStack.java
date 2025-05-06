package interviewQA.StackAndQueues;

import java.util.Stack;

public class ImplementQueueUsingStack {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        public void push(int x) {
            int size1 = st1.size();
            while(size1 != 0){
                st2.push(st1.peek());
                st1.pop();
                size1--;
            }
            st1.push(x);
            int size2 = st2.size();
            while(size2 != 0){
                st1.push(st2.peek());
                st2.pop();
                size2--;
            }
        }

        public int pop() {
            return st1.pop();
        }

        public int peek() {
            return st1.peek();
        }

        public boolean empty() {
            return st1.isEmpty();
        }

}
