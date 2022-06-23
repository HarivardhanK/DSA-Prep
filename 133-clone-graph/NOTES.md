### BFS
```
class Solution {
public Node cloneGraph(Node node) {
if(node == null) return node;
// create a map lets say visisted with {Integer, node} because
// we can store the created node of deepcopy(new Graph)
// create a queue and push the root node of the origraph
// create a new node this will be our head of the deepcopy(new graph)
// make sure to put it in our visited{newnode.val, newnode}
// while the queue is not empty
// poll a node from the queue this node is in original graph
// get the node from the visited map with the node's value
// this node is we get from map is node of deepcopy graph(new graph)
// traverse through the nodes of the original graph
// if the node is already created ie already present in our map
// then get it and add it as a neighbour
// if the node is not present then create it and put it in our map
// and then add it as a neighbout
// at the end of the day return newnode of the deepcopy graph
Map<Integer,Node> visited = new HashMap<>();
Queue<Node> q = new LinkedList<>();
q.offer(node);