class Solution {
    public int MAH(int h[]){
        int nsl[]=new int[h.length];
        int psl[]=new int[h.length];
        Stack<Integer> stk = new Stack<>();
        for(int i=h.length-1;i>=0;i--){
            while(!stk.empty() && h[stk.peek()]>=h[i]) stk.pop();
            nsl[i]=stk.empty()?h.length-1:stk.peek()-1;
            stk.push(i);
        }
        while(stk.size()>0) stk.pop();
        for(int i=0;i<h.length;i++){
            while(stk.size()>0 && h[stk.peek()]>=h[i]) stk.pop();
            psl[i]=stk.empty()?0:stk.peek()+1;
            stk.push(i);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<h.length;i++){
            max=Math.max(max,(nsl[i]-psl[i]+1)*h[i]);
        }
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        int[] arr = new int[matrix[0].length];
        Arrays.fill(arr,0);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0') arr[j]=0;
                else arr[j]=arr[j]+1;
            }
            max=Math.max(max,MAH(arr));
        }
        return max;
    }
}