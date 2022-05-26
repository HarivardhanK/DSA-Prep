#### Time complexity is O(N) and Space complexity is O(1)
```
class Node{
Node[] link = new Node[26];
boolean end = false;
Node(){}
boolean containsChar(char c){
return (link[c - 'a']!=null);
}
Node get(char c){
return (link[c - 'a']);
}
void put(char c, Node node){
link[c - 'a'] = node;
}
void setEnd(){
end = true;
}
boolean isEnd(){
return end;
}