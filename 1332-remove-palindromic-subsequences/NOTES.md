```
class Solution {
private boolean palin(String s) {
int sind = 0, eind = s.length() - 1;
while(sind < eind) {
if(s.charAt(sind) != s.charAt(eind)) {
return false;
}
sind++; eind--;
}
return true;
}
public int removePalindromeSub(String s) {
boolean ispalin = palin(s);
// if the whole string is palindrome then we need only one step
if(ispalin) {
return 1;
}
//at max we need two steps to remove the palindromic subsequence
// because s = "abaabaab"
// step 1: remove chars of a
// step 2: remove chars of b
return 2;
}
}
```