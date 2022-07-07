Fails because we can't decide which to match so use dp for choosing both characters
```
class Solution {
public boolean isInterleave(String s1, String s2, String s3) {
int i = 0, j = 0, k = 0;
while(i < s1.length() && j < s2.length()) {
if(s1.charAt(i) == s3.charAt(k)) {
i++;k++;
}
else if(s2.charAt(j) == s3.charAt(k)) {
j++;k++;
}
else {
return false;
}
}
while(i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
i++; k++;
}
while(j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
j++; k++;
}
if(i==s1.length() && j==s2.length()) return true;
return false;
}
}
```