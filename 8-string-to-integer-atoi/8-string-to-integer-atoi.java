class Solution {
    public int myAtoi(String s) {
        if(s.length() == 0) return 0;
        
        int n = s.length();
        int i = 0; 
        boolean isPlus = true;
        //ignore the leading white spaces
        while(i < n && s.charAt(i) == ' ') i++;
        //check the sign
        if(i < n && s.charAt(i) == '-'){
            isPlus = false;
            i++;
        }
        else if(i<n && s.charAt(i) == '+') i++;
        
        // if there is no intergers
        if(i<n && !(s.charAt(i) >= '0' && s.charAt(i) <= '9'))
            return 0;
        //leading zeroes
        while(i<n && s.charAt(i) == '0') i++;
        
        int j = i;
        while(j<n && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
            j++;
        }
        
        long ans;
        if(i==n || i==j) return 0;
        else if(j - i > 11){
            if(isPlus) 
                return Integer.MAX_VALUE;
            return Integer.MIN_VALUE;
        }
        else
            ans = Long.parseLong(s.substring(i, j));
        
        if(!isPlus) ans *= -1;
        if(ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        
        return (int)ans;
    }
}