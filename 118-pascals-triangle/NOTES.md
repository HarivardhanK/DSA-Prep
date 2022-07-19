see the triangle like this - just peek back previous rows - previous col and current col
​
1
1 1
**1 2** 1
1** 3** 3 1
​
​
**Code**
```
class Solution {
public List<List<Integer>> generate(int numRows) {
if(numRows == 0)
return new ArrayList<>();
List<List<Integer>> pasTri = new ArrayList<>();
//adding first row
pasTri.add(new ArrayList<>());
pasTri.get(0).add(1);
​
List<Integer> row = new ArrayList<>();
​
for(int i = 1; i < numRows; i++) {
for(int j = 0; j < i + 1; j++) {
if(j == 0 || j == i){
row.add(1);