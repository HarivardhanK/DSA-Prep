class Solution {
    boolean isvalid(int row, int col, int [][]grid){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]==1){
          return false;
        }
        return true;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1 || grid[grid.length-1][grid.length-1]==1) return -1;
        int sr = 0, sc = 0, tr = grid.length-1, tc = grid.length-1;
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(sr, sc, 1));
        int mindis = (int)1e9;

        while(!q.isEmpty()){
          int size = q.size();
          while(size-->0){
            Tuple  t = q.poll();
            int row = t.row;
            int col = t.col;
            int dis = t.dis;
            if(row==tr && col==tc){
              mindis = Math.min(mindis, dis);
            }
            // up dir
            if(isvalid(row-1,col,grid)){
              q.offer(new Tuple(row-1, col, dis+1));
              grid[row-1][col] = 1;
            }
            // left - dir
            if(isvalid(row,col-1 ,grid)){
              q.offer(new Tuple(row, col-1, dis+1));
              grid[row][col-1] = 1;
            }
            // right - dir
            if(isvalid(row,col+1,grid)){
              q.offer(new Tuple(row, col+1, dis+1));
              grid[row][col+1] = 1;
            }
            //down dir
            if(isvalid(row+1,col,grid)){
              q.offer(new Tuple(row+1, col, dis+1));
              grid[row+1][col] = 1;
            }
              
            // up left dir
            if(isvalid(row-1,col-1,grid)){
              q.offer(new Tuple(row-1, col-1, dis+1));
              grid[row-1][col-1] = 1;
            }
            // down left - dir
            if(isvalid(row+1,col-1 ,grid)){
              q.offer(new Tuple(row+1, col-1, dis+1));
              grid[row+1][col-1] = 1;
            }
            // up - right - dir
            if(isvalid(row-1,col+1,grid)){
              q.offer(new Tuple(row-1, col+1, dis+1));
              grid[row-1][col+1] = 1;
            }
            //down right dir
            if(isvalid(row+1,col+1,grid)){
              q.offer(new Tuple(row+1, col+1, dis+1));
              grid[row+1][col+1] = 1;
            }
          }
        }
        return mindis==(int)1e9?-1:mindis;
    }
}
class  Tuple{
    int row, col, dis;
    Tuple(int row, int col, int dis){
          this.row = row;
          this.col = col;
          this.dis = dis;
    }
}
