class Solution {
    private int shiftandCount(int[][] img1, int[][] img2, int xshift, int yshift) {
        int leftShiftCount = 0, rightShiftCount = 0;
        int row2 = 0;
        for(int i = yshift; i < img1.length; i++) {
            int col2 =0;
            for(int j = xshift; j < img1.length; j++) {
                if(img1[i][j] == 1 && img1[i][j] == img2[row2][col2])
                    leftShiftCount++;
                if(img1[i][col2] == 1 && img1[i][col2] == img2[row2][j])
                    rightShiftCount++;
                col2++;
            }
            row2++;
        }
        return Math.max(leftShiftCount, rightShiftCount);
    }
    public int largestOverlap(int[][] img1, int[][] img2) {
        int max =0;
        for(int i =0;i < img1.length; i++) {
            for(int j = 0;j < img1.length; j++) {
                max = Math.max(max, shiftandCount(img1, img2, i, j));
                max = Math.max(max, shiftandCount(img2, img1, i, j));
            }
        }
        return max;
    }
}