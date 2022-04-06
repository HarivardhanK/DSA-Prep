class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long ans=0;
        int MOD = 1_000_000_007;
        Arrays.sort(arr);
        for(int i=0;i<arr.length-2;i++){
            int smalltar = target-arr[i];
            int j=i+1,k=arr.length-1;
            while(j<k){
                if(arr[j]+arr[k]>smalltar) k--;
                else if(arr[j]+arr[k]<smalltar) j++;
                else if(arr[j]!=arr[k]){
                    int left=1,right=1;
                    while(j+1<k && arr[j]==arr[j+1]){
                        left++; j++;
                    }
                    while(k-1>j && arr[k]==arr[k-1]){
                        right++; k--;
                    }
                    ans+=left*right;
                    ans%=MOD;
                    j++;
                    k--;
                }
                else{
                    ans+= (k-j+1)*(k-j)/2;
                    ans%=MOD;
                    break;
                }
            }
        }
        return (int)ans;
    }
}