class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1) return 1;
        int prev[] = new int[n];
        Arrays.fill(prev,1);
        for(int r=1;r<m;r++){
            int curr[]=new int[n];
            for(int c=0;c<n;c++){
                //base cond
                if(c==0)
                    curr[c]=1;
                else 
                    curr[c]=prev[c]+curr[c-1];
                
            }
            prev=curr;
        }
        return prev[n-1];
    }
}