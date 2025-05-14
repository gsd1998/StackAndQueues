package interviewQA.StackAndQueues;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int arr[] = new int[m];
        int maxi = 0;
        for(int row = 0; row <= n-1; row++){
            for(int col = 0; col <= m-1; col++){
                if(matrix[row][col] == '1'){
                    arr[col] = arr[col] + 1;
                }else{
                    arr[col] = 0;
                }
            }
            maxi = Math.max(maxi, largestHistogram(arr));
        }
        return maxi;
    }

    public int largestHistogram(int[] arr){
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
}
