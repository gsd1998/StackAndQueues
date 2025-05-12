package interviewQA.StackAndQueues;

import java.util.Stack;

public class SumOfSubarrayMins {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int n = arr.length;
        for(int i = 0; i <= n-1; i++){
            int mini = Integer.MAX_VALUE;
            for(int j = i; j <= n-1; j++){
                mini = Math.min(mini, arr[j]);
                sum = sum + mini;
            }
        }
        return (int)sum;
    }

    public int sumSubarrayMinsOptimised(int[] arr) {
        long sum = 0;
        int mod = (int)1e9+7;
        int n = arr.length;
        long[] nsel = getNsel(arr, n);
        long[] nser = getNser(arr, n);
        for(int i = 0; i <= n-1; i++){
            long left = i - nsel[i];
            long right = nser[i] - i;
            long product = (left * right * arr[i]) % mod;
            sum = (sum + product) % mod;
        }
        return (int)sum;
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
}
