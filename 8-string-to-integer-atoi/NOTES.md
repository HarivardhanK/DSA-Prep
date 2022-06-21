```
class Solution {
public int myAtoi(String s) {
String str="";
boolean isneg=false;
boolean ispos=false;
for(int i=0;i<s.length();i++){
if((s.charAt(i)<='Z' && s.charAt(i)>='A') || (s.charAt(i)<='z' && s.charAt(i)>='a') || s.charAt(i)=='.' || s.charAt(i)==',')
break;
if(str.length()>0 &&( s.charAt(i)=='+' || s.charAt(i)=='-') ) break;
if(str.length()==0 && s.charAt(i)=='-'){
if(ispos) break;
str+=s.charAt(i);
isneg=true;
}
if(str.length()==0 && s.charAt(i)=='+'){
if(isneg) break;
ispos=true;
}
if(s.charAt(i)>='0' && s.charAt(i)<='9')
str+=s.charAt(i);
}
if(str.length()>0){
long ans = Long.parseLong(str);
if(ans>= Integer.MAX_VALUE) return Integer.MAX_VALUE;
else if(ans<=Integer.MIN_VALUE) return Integer.MIN_VALUE;
return (int)ans;
}
return 0;
}
}
```