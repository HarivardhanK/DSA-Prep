// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size) {
        //ger
        int majele = a[0], count = 0;
        for(int i = 0; i < a.length; i++){
            if(majele == a[i]) 
                count++;
            else
                count--;
            
            if(count == 0){
                majele = a[i];
                count = 1;
            }
        }
        
        count = 0;
        for(int ele: a){
            if(ele == majele) count++;
        }
        
        if(count > a.length/2) 
            return majele;
        return -1;
    }
}