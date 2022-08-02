class Solution {
    private int getRank(int[][] matrix, int target) {
        int n = matrix.length, i = 0, j = n - 1;
        int count = 0;
        while(i < n && j >= 0) {
            if(matrix[i][j] > target) j--;
            else {
                count += j + 1;
                i++;
            }
        }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, low = matrix[0][0], high = matrix[n - 1][n - 1];
        while(low < high) {
            int mid = low + (high - low)/2;
            if(getRank(matrix, mid) < k) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}

/*
[[1,5,9],
[10,11,13],
[12,13,15]]
*/