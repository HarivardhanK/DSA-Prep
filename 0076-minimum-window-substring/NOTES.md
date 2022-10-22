```
class Solution {
public String minWindow(String s, String t) {
Map<Character, Integer> map = new HashMap<>();
for(char ch:t.toCharArray()){
map.put(ch,map.getOrDefault(ch,0)+1);
}
int count=map.size(), ans = Integer.MAX_VALUE;
int start = 0, end = s.length()-1;
for(int i=0,j=0;j<s.length();j++){
if(map.containsKey(s.charAt(j))){
map.put(s.charAt(j),map.get(s.charAt(j))-1);
if(map.get(s.charAt(j))==0) count--;
}
if(count==0){
while(i<s.length() && count==0){
if(map.containsKey(s.charAt(i))){
map.put(s.charAt(i),map.get(s.charAt(i))+1);
if(map.get(s.charAt(i))==1) count++;
}
i++;
}
if(ans>(j-i+2)){
ans = j-i+2;
start=i-1;
end=j;
}
}
}
return (ans==Integer.MAX_VALUE)?"":s.substring(start,end+1);
}
}
```