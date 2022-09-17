```
case 1:
for the empty string case eg:""+"aba" = """aba" , "aba"""
case 2:
for the reflection case: "abc"+"cba" = "abccba", "cbaabc"
case 3:
for the tricky case
eg: "abade" + "ed" -> "aba" is a palindrome and search for the rev(de)
because if we find we need to attach it in front of "abade"
eg: "deaba" + "ed" -> "aba" is a palindrom and search for the (de)
because if we find we need to attach it at the end of "deaba"
```
### Optimal solution:
```
​
```
​
​
​
### Brute force:
TC: O(n^2*k) and SC: O(1) -> gives TLE
```
class Solution {
private boolean ispalin(String s) {
return (new StringBuilder(s).reverse().toString().equals(s));
}
public List<List<Integer>> palindromePairs(String[] words) {
List<List<Integer>> ans = new ArrayList<>();
for(int i = 0; i < words.length; i++) {
for(int j = i+1; j < words.length; j++) {
if(ispalin(words[i]+words[j])) {
ans.add(Arrays.asList(new Integer[]{i,j}));
}
if(ispalin(words[j]+words[i])) {
ans.add(Arrays.asList(new Integer[]{j,i}));
}
}
}
return ans;
}
}
```