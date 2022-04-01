### Solution1: clean code
​
​
​
### Solution 2:
​
```
class Solution {
public int lengthOfLongestSubstring(String s) {
HashMap<Character,Integer> map = new HashMap<>();
int max=0,i=0,j=0;
while(j<s.length()){
map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
if(map.get(s.charAt(j))==1){
max = Math.max(j-i+1,max);
j++;
}
else{
while(map.get(s.charAt(j))>1){
map.put(s.charAt(i),map.get(s.charAt(i))-1);
if(map.get(s.charAt(i))==0) map.remove(s.charAt(i));
i++;
}
j++;
}
}
return max;
}
}
```