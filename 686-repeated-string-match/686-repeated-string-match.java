class Solution {
    private boolean isFound(StringBuilder a, String b) {
        for(int i = 0; i < a.length(); i++) {
            int start = i;
            int j = 0;
            
            while(start < a.length() && j < b.length() && a.charAt(start) == b.charAt(j)) {
                j++; start++;
            }
            
            if(j == b.length()) return true;   
        }
        return false;
    }
    public int repeatedStringMatch(String a, String b) {
        //rabin karp
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        
        // if(isFound(sb, b)) 
        //     return count;
        // else if(isFound(sb.append(a), b)) 
        //     return count + 1;
        if(sb.toString().contains(b)) 
            return count;
        else if(sb.append(a).toString().contains(b)) 
            return count + 1;
        return -1;
    }
}