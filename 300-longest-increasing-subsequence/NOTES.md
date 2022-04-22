public static void lengthOfLIS(int[] nums) {
int n=nums.length;
int lis[] = new int[n];
//base case filling 0's in nth row -- by default the values are 0
//nested loops
int max=1,maxind=0;
Arrays.fill(lis,1);
for(int ind=0;ind<n;ind++){
for(int prevind=0;prevind<ind;prevind++){
if(nums[ind]>nums[prevind]){
if(lis[ind]<1+lis[prevind])
lis[ind]=1+lis[prevind];
}
}
if(max<lis[ind]){
max=lis[ind];
maxind=ind;
}
}
List<Integer> ans = new ArrayList<>();
while(maxind>=0){
ans.add(nums[maxind]);
int ind=maxind;
while(ind>=0 && lis[maxind]-1!=lis[ind]) ind--;
maxind=ind;
}
Collections.reverse(ans);
System.out.println(ans);
return;
}
}
```