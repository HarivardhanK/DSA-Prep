### counting sort
​
ex:
Input: nums = [1,3,4,2,2]
Output: 2
after counting sort: [1 2 3 4 2 ] last is the duplicate element
```
class Solution {
public int findDuplicate(int[] nums) {
int i=0;
while(i<nums.length){
if(nums[nums[i]-1]!=nums[i]){
int temp = nums[i];
nums[i]=nums[temp-1];
nums[temp-1]=temp;
}
else{
i++;
}
}
// for(i=0;i<nums.length;i++){
//     if(nums[i]!=i+1) return nums[i];
// }
return nums[nums.length-1] ;
}
}
```