class Solution {
    public String addBinary(String a, String b) {
        String ans="";
        int i=a.length()-1,j=b.length()-1;
        char carry='0';
        while(i>=0 && j>=0){
            if(a.charAt(i)=='0' && b.charAt(j)=='0'){
                ans=carry+ans;
                carry='0';
            }
            else if(a.charAt(i)=='0' && b.charAt(j)=='1'||a.charAt(i)=='1' && b.charAt(j)=='0'){
                if(carry=='1'){
                    ans='0'+ans;
                }
                else{
                   ans='1'+ans; 
                }
            }
            else if(a.charAt(i)=='1' && b.charAt(j)=='1'){
                if(carry=='1'){
                    ans='1'+ans;
                }
                else{
                    ans='0'+ans;
                    carry='1';
                }
            }
            i--;j--;
        }
        while(i>=0){
            if(a.charAt(i)=='0'){
                ans=carry+ans;
                carry='0';
            }
            else{
                if(carry=='1'){
                    ans='0'+ans;
                }
                else{
                    ans='1'+ans;
                }
            }
            i--;
        }
        while(j>=0){
            if(b.charAt(j)=='0'){
                ans=carry+ans;
                carry='0';
            }
            else{
                if(carry=='1'){
                    ans='0'+ans;
                }
                else{
                    ans='1'+ans;
                }
            }
            j--;
        }
        if(carry=='1')
            ans='1'+ans;
        return ans;
    }
}