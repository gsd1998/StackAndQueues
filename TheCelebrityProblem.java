package interviewQA.StackAndQueues;

public class TheCelebrityProblem {

    public static void main(String[] args) {
        //int[][] matrix = { {0,1,1,0}, {0,0,0,0}, {0,1,0,0}, {1,1,0,0} };
        int[][] matrix = {
                {0,1,0},
                {0,0,1},
                {1,0,0}
        };
        int celebrity = findCelebrity(matrix);
        System.out.println(celebrity);
    }

    public static int findCelebrity(int[][] mat) {
        int top = 0;
        int bottom = mat.length-1;
        while(top < bottom){
            if(mat[top][bottom] == 0){
                bottom--;
            }
            else if(mat[bottom][top] == 0){
                top++;
            }else{
                top++;
                bottom--;
            }
        }
        for(int i=0; i <= mat[0].length-1; i++){
            if(i == top){
                continue;
            }
            if(mat[top][i] == 1 || mat[i][top] == 0) {
                return -1;
            }
        }
        return top;
    }

}
