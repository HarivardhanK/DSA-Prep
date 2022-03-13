class Solution {
    public char findTheDifference(String s, String t) {
        if(s.length()==0) return t.charAt(0);
        int i=0;
        char sarr[] = s.toCharArray();
        Arrays.sort(sarr);
        s= new String(sarr);
        char tarr[] = t.toCharArray();
        Arrays.sort(tarr);
        t= new String(tarr);
        while(i<s.length()){
            if(sarr[i]!=tarr[i]) break;
            i++;
        }
        return tarr[i];
    }
}