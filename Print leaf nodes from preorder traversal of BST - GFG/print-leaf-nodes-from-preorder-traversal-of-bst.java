//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            int[] ans = ob.leafNodes(arr, N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] leafNodes(int arr[], int N) {
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        
        stk.push(arr[0]);
        for(int i = 1; i < N; i++) {
            if(arr[i] < stk.peek()) stk.push(arr[i]);
            else {
                int temp = stk.peek();
                int removedEle = 0;
                while(stk.size() > 0 && arr[i] > stk.peek()) {
                    stk.pop(); 
                    removedEle++;
                }
                stk.push(arr[i]);
                if(removedEle >= 2) 
                    ans.add(temp);
            }
        }
        ans.add(stk.peek());
        int[] leaf = new int[ans.size()];
        for(int i =0;i < ans.size(); i++) 
            leaf[i] = ans.get(i);
        return leaf;
    }
}
// left root right
// [1,2,3,4,5]
