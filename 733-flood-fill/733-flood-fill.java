class Solution {
    private void solve(int[][] image, int sr, int sc, int newColor, int color) {
        if(sr > image.length - 1 || sc > image[0].length - 1 || sr < 0 || sc < 0 || image[sr][sc] != color || newColor == color) return;
        
        image[sr][sc] = newColor;
        solve(image, sr+1, sc, newColor, color);
        solve(image, sr, sc+1, newColor, color);
        solve(image, sr-1, sc, newColor, color);
        solve(image, sr, sc-1, newColor, color);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        solve(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
}