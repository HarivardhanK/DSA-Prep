//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            out.println(ob.decodedString(s));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String decodedString(String s){
        // code here
        Stack<StringBuilder> st=new Stack<>();
        
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)!=']') {
                StringBuilder sb1=new StringBuilder(""+s.charAt(i));
                st.push(sb1);
            }
            else {
                StringBuilder sb=new StringBuilder();
                StringBuilder num=new StringBuilder();
                while(!st.isEmpty() && (st.peek().length()>1 || (st.peek().length()==1 && st.peek().charAt(0)!='['))) { //popping all and adding to sb until we come across '['
                    sb.append(st.pop());
                }
                st.pop();
                while(!st.isEmpty() && 
                    (st.peek().length()==1 && st.peek().charAt(0)>='0' && st.peek().charAt(0)<='9')) { 
                    num.append(""+st.pop());
                }
               
                int times=1;
                if(num.length()>0)
                    times=Integer.valueOf(num.reverse().toString());
                    
                StringBuilder toAppend=new StringBuilder();
                for(int j=0;j<times;j++) {
                    toAppend.append(sb);
                }
                st.push(toAppend);
            }
        }
        StringBuilder res=new StringBuilder();
        while(!st.isEmpty()) {
            res.append(st.pop());
        }
        return res.reverse().toString();
    }
}