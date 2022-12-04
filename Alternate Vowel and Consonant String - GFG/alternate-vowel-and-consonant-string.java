//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine().trim();
            
            Solution ob = new Solution();
            String ans = ob.rearrange(S, N);
            
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public String rearrange(String S, int N){
        // int[] vowels = new int[5];
        int[] freq = new int[26];
        // int st = 26;
        int smv = 'u', smc = 'z';
        
        for(char ch: S.toCharArray()) {
            freq[ch-'a']++;
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') 
                smv = Math.min(smv, ch-'a');
            else smc = Math.min(smc, ch-'a');
        }
        
        int vows = freq['a'-'a']+freq['e'-'a']+freq['i'-'a']+freq['o'-'a']+freq['u'-'a'];
        // System.out.println(vows+" "+st);
        if(vows > (N+1)/2 || (N-vows) > (N+1)/2) return "-1";
        
        String vow = "aeiou";
        StringBuilder sb = new StringBuilder(S);
        int i, j;
        if(vows >= N-vows && smv < smc) {i = 0; j = 1;}
        else {i = 1; j = 0;}
        for(char ch: vow.toCharArray()) {
            int f = freq[ch-'a'];
            while(f-- > 0){
                if(i >= sb.length()) break;
                sb.setCharAt(i, ch);
                i+=2;
            }
        }
        for(i = 0; i < 26; i++) {
            if(i == 0 || i == 4 || i == 'i'-'a' || i == 'o'-'a' || i == 'u'-'a') continue;
            int f = freq[i];
            while(f-- > 0) {
                if(j >= sb.length()) break;
                sb.setCharAt(j, (char)('a'+i));
                j+=2;
            }
        }
        return sb.toString();
    }
}