class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<p.length();i++){
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);
        }
        int count=map.size();
        int i=0,j=0,k=p.length();
        while(j<s.length()){
            if(map.containsKey(s.charAt(j))){
                int temp= map.get(s.charAt(j));
                map.put(s.charAt(j),temp-1);
                if(temp-1==0) count--;
            }
            if(j-i+1<k) j++;
            else{
                if(count==0) ans.add(i);
                if(map.containsKey(s.charAt(i))){
                    int temp= map.get(s.charAt(i));
                    map.put(s.charAt(i),temp+1);
                    if(temp+1==1) count++;
                }
                i++;j++;
            }
        }
        return ans;
    }
}