class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int r=1;r<triangle.size();r++){
            for(int c=0;c<triangle.get(r).size();c++){
                if(c==0){ 
                    triangle.get(r).set(c,triangle.get(r).get(c)+triangle.get(r-1).get(c));
                    continue;    
                }
                if(c==triangle.get(r).size()-1){
                    triangle.get(r).set(c,triangle.get(r).get(c)+triangle.get(r-1).get(c-1));
                    continue;
                }
                int minnum=Math.min(triangle.get(r-1).get(c-1),triangle.get(r-1).get(c));
                triangle.get(r).set(c,triangle.get(r).get(c)+minnum);
            }
        }
        int min=Integer.MAX_VALUE;
        for(int c=0;c<triangle.get(triangle.size()-1).size();c++){
            min=Math.min(min,triangle.get(triangle.size()-1).get(c));
        }
        return min;
    }
}