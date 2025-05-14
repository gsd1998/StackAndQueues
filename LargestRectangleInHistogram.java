package interviewQA.StackAndQueues;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int maxi = 0;
        for(int i = 0; i <= arr.length-1; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                int element = st.peek();
                st.pop();
                int nextSmallest = i;
                int pervSmallest = st.isEmpty() ? -1 : st.peek();
                int maxArea = (nextSmallest - pervSmallest - 1) * arr[element];
                maxi = Math.max(maxi, maxArea);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int element = st.peek();
            st.pop();
            int pervSmallest = st.isEmpty() ? -1 : st.peek();
            int nextSmallest = arr.length;
            int maxArea = (nextSmallest - pervSmallest - 1) * arr[element];
            maxi = Math.max(maxi, maxArea);
        }
        return maxi;
    }

    /*******************************/

    public int largestRectangleAreaBrute(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int maxi = 0;
        int n = arr.length;
        int[] nsel = getNsel(arr, n);
        int[] nser = getNser(arr, n);
        for(int i = 0; i <= arr.length-1; i++){
            int maxArea = (nser[i] - nsel[i] - 1) * arr[i];
            maxi= Math.max(maxi, maxArea);
        }
        return maxi;
    }

    public int[] getNsel(int[] arr, int n){
        int[] nsel = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int k = 0; k <= n-1; k++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[k]){
                st.pop();
            }
            nsel[k] = st.isEmpty() ? -1 : st.peek();
            st.push(k);
        }
        return nsel;
    }

    public int[] getNser(int[] arr, int n){
        int[] nser = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int k = n-1; k >= 0; k--){
            while(!st.isEmpty() && arr[st.peek()] > arr[k]){
                st.pop();
            }
            nser[k] = st.isEmpty() ? n : st.peek();
            st.push(k);
        }
        return nser;
    }
}
