// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    static boolean isValid(int[][] grid, int row, int col, int num) {
        //row & column
        for(int i=0; i < grid.length; i++){
            if(grid[row][i] == num) 
                return false;
                
             if(grid[i][col] == num) 
                return false;                
        }
        
        //grid
        int sr = row - row % 3;
        int sc = col - col % 3;
        
        for(int i = sr; i < sr + 3; i++) {
            for(int j = sc; j < sc + 3; j++){
                if(grid[i][j] == num)
                    return false;
            }
        }
        
        return true;
    }
    static boolean solve(int[][] grid, int row, int col) {
        if(row == grid.length)
            return true;
        
        int newr = 0;
        int newc = 0;
        if(col == grid.length-1) {
            newr = row + 1;
            newc = 0;   
        }
        else {
            newr = row;
            newc = col + 1;
        }
        
        if(grid[row][col] != 0) {
            if(solve(grid, newr, newc))
                return true;
        }
        else {
            for(int i=1; i <= 9; i++){
                if(isValid(grid, row, col, i)){
                    grid[row][col] = i;
                    if(solve(grid, newr, newc)){
                        return true;
                    }
                    else{
                        grid[row][col] = 0;
                    }
                }
            }
        }
        return false;
    }
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        return solve(grid, 0, 0);
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                System.out.print(grid[i][j] +" ");
            }
        }
    }
}