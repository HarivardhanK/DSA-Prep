class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] ls,rs;//ls=leftSmallerIndex rs=rightSmallerIndex
        ls = new int[heights.length];
        rs = new int[heights.length];
        Stack<Integer> s =new Stack<>();
        
        //for each element finding lefthandsideSmallest index
        for(int i=0;i<heights.length;i++){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i])
                s.pop(); //popping ele which greater to find smaller
            ls[i]=(s.isEmpty())?0:s.peek()+1;
            s.push(i);
        }
        
        // popping all ele in stack to reuse
        while(!s.isEmpty()) s.pop();
        
        //for each element finding lefthandsideSmallest index
        for(int i=heights.length-1;i>=0;i--){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i])
                s.pop(); //popping ele which greater to find smaller
            rs[i]=(s.isEmpty())?heights.length-1:s.peek()-1;
            s.push(i);
        }
        
        int res=0;
        for(int i=0;i<heights.length;i++){
            res=Math.max(res,heights[i]*(rs[i]-ls[i]+1));
        }
        return res;
    }
}