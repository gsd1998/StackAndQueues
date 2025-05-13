package interviewQA.StackAndQueues;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i <= n-1; i++){
            boolean incomingAstDestroyed  = false;
            while(!st.isEmpty() && asteroids[i] < 0 && st.peek() > 0){
                if(st.peek() < -asteroids[i]){
                    st.pop();
                }
                else if(st.peek() == -asteroids[i]){
                    st.pop();
                    incomingAstDestroyed = true;
                    break;
                }else{
                    incomingAstDestroyed = true;
                    break;
                }
            }
            if(!incomingAstDestroyed)
                st.push(asteroids[i]);
        }
        int size = st.size();
        int[] arr = new int[size];
        while(!st.isEmpty()){
            arr[size-1] = st.pop();
            size--;
        }
        return arr;
    }
}
