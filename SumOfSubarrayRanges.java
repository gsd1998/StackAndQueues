package interviewQA.StackAndQueues;

import java.util.Stack;

public class SumOfSubarrayRanges {

    public long subArrayRanges(int[] arr) {
        long min = sumSubarrayMin(arr);
        long max = sumSubarrayMax(arr);
        return max - min;
    }

    public long sumSubarrayMin(int[] arr) {
        long sum = 0;
        int n = arr.length;
        long[] nsel = getNsel(arr, n);
        long[] nser = getNser(arr, n);
        for(int i = 0; i <= n-1; i++){
            long leftmin = i - nsel[i];
            long rightmin = nser[i] - i;
            long product = (leftmin * rightmin * arr[i]);
            sum = (sum + product);
        }
        return sum;
    }

    public long sumSubarrayMax(int[] arr) {
        long sum = 0;
        int n = arr.length;
        long[] nlel = getNlel(arr, n);
        long[] nler = getNler(arr, n);
        for(int i = 0; i <= n-1; i++){
            long leftmax = i - nlel[i];
            long rightmax = nler[i] - i;
            long product = (leftmax * rightmax * arr[i]);
            sum = (sum + product);
        }
        return sum;
    }


    public long[] getNsel(int[] arr, int n){
        long[] nsel = new long[n];
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

    public long[] getNser(int[] arr, int n){
        long[] nser = new long[n];
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

    public long[] getNlel(int[] arr, int n){
        long[] nlel = new long[n];
        Stack<Integer> st = new Stack<>();

        for(int k = 0; k <= n-1; k++){
            while(!st.isEmpty() && arr[st.peek()] <= arr[k]){
                st.pop();
            }
            nlel[k] = st.isEmpty() ? -1 : st.peek();
            st.push(k);
        }
        return nlel;
    }

    public long[] getNler(int[] arr, int n){
        long[] nler = new long[n];
        Stack<Integer> st = new Stack<>();

        for(int k = n-1; k >= 0; k--){
            while(!st.isEmpty() && arr[st.peek()] < arr[k]){
                st.pop();
            }
            nler[k] = st.isEmpty() ? n : st.peek();
            st.push(k);
        }
        return nler;
    }

}
