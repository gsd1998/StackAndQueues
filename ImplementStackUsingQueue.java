package interviewQA.StackAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
        Queue<Integer> q = new LinkedList<>();

        public void push(int x) {
            int size = q.size();
            q.add(x);
            while(size != 0){
                q.add(q.peek());
                q.remove();
                size--;
            }
        }

        public int pop() {
            return q.remove();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            if(q.size() == 0){
                return true;
            }
            return false;
        }
}
