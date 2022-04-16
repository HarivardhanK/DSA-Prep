class Solution {
    public long[] sumOfThree(long num) {
        if(num%3!=0) return new long[]{};
        long ans[] = new long[3];
        num=num/3;
        for(int i=-1;i<=1;i++) ans[i+1]=num+i;
        return ans;
    }
}