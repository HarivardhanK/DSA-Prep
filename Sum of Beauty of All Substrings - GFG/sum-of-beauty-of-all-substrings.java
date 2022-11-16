//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.beautySum(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int beautySum(String s) {
        int n = s.length(), ans = 0;
        for(int i = 0;i < n; i++) {
            int[] map = new int[26];
            int max = 0, min = (int)1e9;
            // char mxch = '$', mnch = '$';
            for(int j = i; j < n; j++) {
                map[s.charAt(j)-'a']++;
                // if(max < map[s.charAt(j)-'a'] ) {
                //     mxch = s.charAt(j);
                //     max = map[s.charAt(j)-'a'];
                // }
                // else if(min > map[s.charAt(j)-'a'] && s.charAt(j) != mxch) {
                //     mnch = s.charAt(j);
                //     min = map[s.charAt(j)-'a'];
                // }
                
                // if(mxch != '$' && mnch != '$') ans += max - min;
                
                // max = Math.max(max, map[s.charAt(j)-'a']);
                // min = Math.min(min, map[s.charAt(j)-'a']);
                // if(min != (int)1e9) {
                //     ans += max-min;
                // }
                min = (int)1e9;
                for(int ele: map) {
                    if(max < ele) max = ele;
                    else if(ele > 0 && min > ele) min = ele;
                }
                if(min != (int)1e9)
                    ans += max-min;
            }
        }
        return ans;
    }
}
        
