class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        StringBuilder res = new StringBuilder("1");
        for(int i=1;i<n;i++){
            StringBuilder curr = new StringBuilder();
            int ind=0;
            
            while(ind<res.length()){
                int count=1;
                while(ind+1<res.length() && res.charAt(ind)==res.charAt(ind+1)){
                    count++;
                    ind++;
                }
                curr.append(""+count+res.charAt(ind));
                ind++;
            }
            res=curr;
        }
        return res.toString();
    }
}