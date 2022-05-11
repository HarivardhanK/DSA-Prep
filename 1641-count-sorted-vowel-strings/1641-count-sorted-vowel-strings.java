class Solution {
    public int countVowelStrings(int n) {
        int pre[] = new int[5];
        Arrays.fill(pre,1);
        for(int i=0;i<n-1;i++){
            int curr[] = new int[5];

            int sum=0;
            for(int ele:pre) sum+=ele;
            
            for(int j=0;j<5;j++){
                curr[j] = sum;
                sum-=pre[j];
            }
            
            pre=curr;
        }
        int sum=0;
        for(int ele:pre) sum+=ele;
        return sum;
    }
}