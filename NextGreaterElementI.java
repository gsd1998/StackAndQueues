package interviewQA.StackAndQueues;

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
}
