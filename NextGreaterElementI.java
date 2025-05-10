package interviewQA.StackAndQueues;
import java.util.Stack;
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] arr = new int[n1];
        for(int i = 0; i < n1; i++){
            for(int j = 0; j < n2; j++){
                if(nums1[i] == nums2[j]){
                    if(j == n2-1){
                        arr[i] = -1;
                        break;
                    }else if(nums2[j] > nums2[j+1]){
                        int x = nums2[j];
                        while(j < n2-1){
                            if(x < nums2[j+1]){
                                arr[i] = nums2[j+1];
                                break;
                            }
                            if(j == n2-2){
                                arr[i] = -1;
                                break;
                            }
                            j++;
                        }
                    }else{
                        arr[i] = nums2[j+1];
                        break;
                    }
                }
            }
        }

        return arr;
    }
    
    public int[] nextGreaterElementOptimised(int[] nums1, int[] nums2) {
        int[] nge = ngeForNums2(nums2);
        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    ans[i] = nge[j];
                }
            }
        }
        return ans;
    }

    public int[] ngeForNums2(int[] nums2){
        Stack<Integer> st = new Stack<>();
        int n2 = nums2.length;
        int[] nge = new int[n2];
        for(int i = n2-1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= nums2[i]){
                st.pop();
            }
            nge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums2[i]);
        }
        return nge;
    }
}
