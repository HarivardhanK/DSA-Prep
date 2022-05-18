### Brute force:
​
```
class Solution {
public int[] productExceptSelf(int[] nums) {
int newnums[] = new int[nums.length];
for(int i=0;i<nums.length;i++){
int mult = 1;
for(int j=0;j<nums.length;j++){
if(i!=j)
mult*=nums[j];
if(mult==0) break;
}
newnums[i] = mult;
}
return newnums;
}
}
```
​
Given numbers [2, 3, 4, 5], regarding the third number 4, the product of array except 4 is 2*3*5 which consists of two parts: left 2*3 and right 5. The product is left*right. We can get lefts and rights:
​
```
Numbers:     2    3    4     5
Lefts:            2  2*3 2*3*4
Rights:  3*4*5  4*5    5
Let’s fill the empty with 1:
​
Numbers:     2    3    4     5
Lefts:       1    2  2*3 2*3*4
Rights:  3*4*5  4*5    5     1
```
We can calculate lefts and rights in 2 loops. The time complexity is O(n).
​
We store lefts in result array. If we allocate a new array for rights. The space complexity is O(n). To make it O(1), we just need to store it in a variable which is right in @lycjava3’s code.