### Solution1: clean code
```
class Solution {
public int lengthOfLongestSubstring(String s) {
HashMap<Character,Integer> map = new HashMap<>();
int max=0;
for(int i=0,j=0;j<s.length();j++){
if(map.containsKey(s.charAt(j))){
i=Math.max(i,map.get(s.charAt(j))+1);
}
map.put(s.charAt(j),j);
max=Math.max(max,j-i+1);
}
return max;
}
}
```
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