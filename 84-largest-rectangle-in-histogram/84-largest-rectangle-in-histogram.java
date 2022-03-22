class Solution {
    public int largestRectangleArea(int[] heights) {
        int nsl[] = new int[heights.length];
        int psl[] = new int[heights.length];
        Stack<Integer> stk = new Stack<>();
        for(int i=heights.length-1;i>=0;i--){
            while(!stk.empty() && heights[stk.peek()]>=heights[i]) stk.pop();
            nsl[i]=stk.empty()?heights.length-1:stk.peek()-1;
            stk.push(i);
        }
        while(!stk.empty()) stk.pop();
        for(int i=0;i<heights.length;i++){
            while(!stk.empty() && heights[stk.peek()]>=heights[i]) stk.pop();
            psl[i]=stk.empty()?0:stk.peek()+1;
            stk.push(i);
        }
        int max=0;
        for(int i=0;i<heights.length;i++){
            max=Math.max(max,(nsl[i]-psl[i]+1)*heights[i]);
        }
        return max;
    }
}