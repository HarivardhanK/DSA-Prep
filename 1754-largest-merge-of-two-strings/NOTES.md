Iterative approach:
​
class Solution {
public String largestMerge(String word1, String word2) {
StringBuilder merge = new StringBuilder();
int i=0,j=0;
int diff = word1.compareTo(word2);
while(i<word1.length() && j<word2.length()){
//using the compareTo we are looking for the string which have the
//lexicographically largest character in it.
diff = word1.substring(i).compareTo(word2.substring(j));
if(word1.charAt(i)>word2.charAt(j)){
merge.append(word1.charAt(i++));
}
else if(word1.charAt(i)<word2.charAt(j)){
merge.append(word2.charAt(j++));
}
else{
if(diff>0) merge.append(word1.charAt(i++));
else merge.append(word2.charAt(j++));
}
}
if(i<word1.length()) merge.append(word1.substring(i));
if(j<word2.length()) merge.append(word2.substring(j));
return merge.toString();
}
}