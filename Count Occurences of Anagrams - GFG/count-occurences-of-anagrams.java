// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int count=0,ans=0,k=pat.length();
        for(int i=0;i<pat.length();i++){
            map.put(pat.charAt(i),map.getOrDefault(pat.charAt(i),0)+1);
        }
        count=map.size();
        int i=0,j=0;
        
        while(j<txt.length()){
            if(map.containsKey(txt.charAt(j))){
                int temp=map.get(txt.charAt(j));
                map.put(txt.charAt(j),temp-1);
                if(temp-1==0) count--;
            }
            if(j-i+1<k){
                j++;
            }
            else{
                if(count==0) ans++;
                if(map.containsKey(txt.charAt(i))){
                    int temp=map.get(txt.charAt(i));
                    map.put(txt.charAt(i),temp+1);
                    if(temp+1==1) count++;
                }
                i++;j++;
            }
        }
        return ans;
    }
}