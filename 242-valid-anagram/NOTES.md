```
class Solution {
public boolean isAnagram(String s, String t) {
// sort the two string and compare them
//use hashmap to store the character occurences
Map<Character, Integer> map = new HashMap<>();
for(char ch: s.toCharArray())
map.put(ch, map.getOrDefault(ch, 0) + 1);
for(char ch: t.toCharArray()) {
if(!map.containsKey(ch)) return false;
map.put(ch, map.getOrDefault(ch, 0) - 1);
if(map.get(ch) == 0)
map.remove(ch);
}
if(map.size() == 0) return true;
return false;
}
}
```