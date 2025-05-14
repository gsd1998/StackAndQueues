package interviewQA.StackAndQueues;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKDigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i <= num.length() - 1; i++){
            while(!st.isEmpty() && st.peek() > num.charAt(i) && k > 0){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(k > 0){
            st.pop();
            k--;
        }
        if(st.isEmpty()){
            return "0";
        }
        String str = "";
        while(!st.isEmpty()){
            str = str + st.pop();
        }
        String newStr = reverse(str);
        int index = 0;
        for(int j = 0; j <= newStr.length() - 1; j++){
            if(newStr.charAt(j) == '0'){
                index++;
            }else{
                break;
            }
        }
        return newStr.substring(index).length() > 0 ? newStr.substring(index) : "0";
    }
    public String reverse(String str){
        StringBuilder sb = new StringBuilder(str);
        int l = 0;
        int r = sb.length() - 1;
        while(l < r){
            char temp = sb.charAt(l);
            sb.setCharAt(l , sb.charAt(r));
            sb.setCharAt(r,temp);
            l++;
            r--;
        }
        return sb.toString();
    }
}
