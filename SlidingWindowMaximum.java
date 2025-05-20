package interviewQA.StackAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] opArr = new int[n-k+1];
        for(int i = 0; i <= n-k; i++){
            int maxi = nums[i];
            for(int j = i; j < i+k; j++){
                maxi = Math.max(nums[j], maxi);
            }
            opArr[i] = maxi;
        }
        return opArr;
    }

    public int[] maxSlidingWindowOptimised(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int index = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i <= n-1; i++){
            while(!dq.isEmpty() && dq.peek() <= i-k){
                dq.poll();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i >= k-1){
                ans[index++] = nums[dq.peek()];
            }
        }
        return ans;
    }
}
