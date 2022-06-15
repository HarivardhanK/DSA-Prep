}
if(tind==t.length() && sind==s.length()) return true;
return false;
}
public int longestStrChain(String[] words) {
int n = words.length;
Arrays.sort(words, (a,b)->a.length() - b.length());
int dp[] = new int[n];
Arrays.fill(dp,1);
int max=1;
for(int i=0;i<n;i++){
for(int j=0;j<i;j++){
if(checkPosibility(words[i],words[j]) && dp[i]<dp[j]+1){
dp[i]=dp[j]+1;
}
}
max=Math.max(dp[i],max);
}
return max;
}
}
```
​
### using HashMaps
TC: O(NlogN) + O(N*L)  N - len of arr, L is len of each word
SC: O(N) - hashmap
​
```
class Solution {
public int longestStrChain(String[] words) {
if(words == null || words.length == 0) return 0;
int res = 0;
// Sort the words based on their lengths
Arrays.sort(words, (a,b)-> a.length()-b.length());
HashMap<String, Integer> map = new HashMap();
//From shortest word to longest word
for(String w : words) {
//Each word is atleast 1 chain long
map.put(w, 1);
//Form next word removing 1 char each time for each w
for(int i=0; i<w.length(); i++) {
StringBuilder sb = new StringBuilder(w);
String next = sb.deleteCharAt(i).toString();
//If the new chain is longer, update the map
if(map.containsKey(next) && map.get(next)+1 > map.get(w))
map.put(w, map.get(next)+1);
}
//Store max length of all chains
res = Math.max(res, map.get(w));
}
return res;
}
}
```