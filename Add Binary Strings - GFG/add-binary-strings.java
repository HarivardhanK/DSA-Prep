//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            String b = input[1];
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        
        int i = a.length()-1, j = b.length()-1;
        int carry = 0;
        while(i >= 0 && j >= 0) {
            int bita = a.charAt(i)-'0', bitb = b.charAt(j)-'0';
            int t = bita+bitb+carry;
            
            if(t%2 == 0) {
                sb.append("0");
                carry = t/2;
            } 
            else {
                sb.append("1");
                carry = t/2;
            }
            i--;j--;
        }
        while(i >= 0) {
            int t = (a.charAt(i)-'0') + carry;
            if(t == 2) {
                sb.append("0");
                carry = 1;
            }
            else{
                sb.append(t+"");
                carry = 0;
            }
            i--;
        }
        while(j >= 0) {
            int t = (b.charAt(j)-'0') + carry;
            if(t == 2) {
                sb.append("0");
                carry = 1;
            }
            else{
                sb.append(t+"");
                carry = 0;
            }
            j--;
        }
        if(carry == 1) sb.append("1");
        
        while(sb.length() > 0 && sb.charAt(sb.length()-1) == '0') 
            sb.deleteCharAt(sb.length()-1);
        
        return sb.reverse().toString();
    }
}