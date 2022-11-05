//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(S[0]);
            int K = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            
            int arr[] = new int[N];
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxGroupSize(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int maxGroupSize(int[] arr, int N, int k) {
        // code here
        int[] mods = new int[k];
        for(int ele: arr) {
            mods[ele%k]++;
        }
        int ans = 0;
        int lt = 1, rt = k-1;
        while(lt < rt) {
            ans += Math.max(mods[lt++], mods[rt--]);
        }
        
        if(lt == rt && mods[lt] > 0) {
            // adding only one element because if we add multiple ir
            // gives as (4+4)%8 == 0 so add only ele of this mod
            ans++;
        }
        
        // reason look above condition's reason        
        if(mods[0] > 0) ans++;
        
        return ans;
    }
}
// 0 1 2 3 4 5 6 7
// 0 1 1 0 0 0 1 1 