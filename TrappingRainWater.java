package interviewQA.StackAndQueues;

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int total = 0;
        int[] leftMax = getPrefixMax(height, n);
        int[] rightMax = getSuffixMax(height, n);
        for(int i = 0; i <= n-1; i++){
            if(height[i] < leftMax[i] && height[i] < rightMax[i]){
                int unitRainWater = Math.min(leftMax[i], rightMax[i]) - height[i];
                total = total + unitRainWater;
            }
        }
        return total;
    }

    public int[] getPrefixMax(int[] height, int n){
        int[] prefixMax = new int[n];
        prefixMax[0] = height[0];
        for(int i = 1; i <= n-1; i++){
            prefixMax[i] = Math.max(prefixMax[i-1], height[i]);
        }
        return prefixMax;
    }

    public int[] getSuffixMax(int[] height, int n){
        int[] suffixMax = new int[n];
        suffixMax[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--){
            suffixMax[i] = Math.max(suffixMax[i+1], height[i]);
        }
        return suffixMax;
    }

    public int trapOptimsied(int[] arr) {
        int n = arr.length;
        int total = 0;
        int l = 0;
        int r = n-1;
        int leftMax = 0, rightMax = 0;
        while(l < r){
            if(arr[l] <= arr[r]){
                if(leftMax > arr[l]){
                    total += leftMax - arr[l];
                }else{
                    leftMax = arr[l];
                }
                l++;
            }else{
                if(rightMax > arr[r]){
                    total += rightMax - arr[r];
                }else{
                    rightMax = arr[r];
                }
                r--;
            }
        }
        return total;
    }
}
