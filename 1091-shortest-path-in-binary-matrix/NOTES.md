grid[r][c] = 0;
return 1+shortdis;
}
public int shortestPathBinaryMatrix(int[][] grid) {
int ans =  solve(grid,0,0);
return ans>=(int)1e9?-1:ans;
}
}
```
**Haha! Good one!! Upvoting your question, because it really isn't obvious and also because the search for an answer to this type of question provides us a deeper understanding of what is going on. I needed to code and check it myself!
The answer is: because of the way we are traversing the maze when doing the dp algorithm. If the path to the answer is complex enough, you won't calculate the cells on right order. Check the following input.
[
[0,1,0,0,0],
[0,1,0,1,0],
[0,1,0,1,0],
[0,1,0,1,0],
[0,0,0,1,0]
]
//in one line it is: [[0,1,0,0,0],[0,1,0,1,0],[0,1,0,1,0],[0,1,0,1,0],[0,0,0,1,0]]
In your dp algorithm, by the time you are calculating, for example, cell (1,2), you still have't calculated the value for cell (2,2). For dp to work there, you would have to write a code that does that path instead of the usual row in range(len(dp)) col in range(len(dp[row])).
This is where bfs wins (or dfs, even though bfs is more recommended for this problem), in which you follow a path that is dictated by the queue of neighbors.**
​