```
class Solution {
public int longestConsecutive(int[] nums) {
Set<Integer> set = new HashSet<>();
for(int ele: nums)
set.add(ele);
int longestcon = 0;
//iterating over the set
for(int ele: set) {
if(!set.contains(ele - 1)) {
int count = 1;
//looking for next element
while(set.contains(ele + 1)){
count++;
//incrementing the curr element
ele++;
}
longestcon = Math.max(longestcon, count);
}
}
return longestcon;
}
}
```