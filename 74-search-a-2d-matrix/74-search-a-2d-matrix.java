class Solution {
    private boolean binsearch(int[][] matrix, int row, int target) {
        int s = 0, e = matrix[0].length - 1;
        while(s <= e) {
            int mid = (s + e) / 2;
            if(matrix[row][mid] == target)
                return true;
            else if(matrix[row][mid] < target)
                s = mid + 1;
            else
                e = mid - 1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
       if( matrix.length == 0) return false;
        
        int top = 0, down = matrix.length - 1;
        int col = matrix[0].length - 1;
        
        while(top <= down) {
            int mid = (top + down)/2;
            //if target is in between [matrix[mid][0], matrix[mid][col]] search in that row
            if(matrix[mid][0] <= target && matrix[mid][col] >= target)
                return binsearch(matrix, mid, target);
            //else divide the array in two
            else if(matrix[mid][col] < target)
                top = mid + 1;
            else 
                down = mid - 1;
        }
        return false;
    }
}