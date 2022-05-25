class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if(n==0) return 0;
        
        //sort according 
        //width - increasing order if widths equal then sort descending of heights
        Arrays.sort(envelopes, (a, b)-> a[0]==b[0]?b[1] - a[1]:a[0]-b[0]);
        
        int lis[] = new int[n];
        int max = 0;
        
        for(int env[] : envelopes){
            int left = 0, right = max;
            while(left<right){
                int mid = left +(right-left)/2;
                if(lis[mid]<env[1]) left = mid + 1;
                else right = mid;
            }
            lis[left] = env[1];
            if(left == max) max++;
        }
        return max;
    }
}