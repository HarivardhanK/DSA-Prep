class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!map.containsKey(ch)){ 
                map.put(ch,new ArrayList<>());
                map.get(ch).add(i);
                map.get(ch).add(i);
            }
            else
                map.get(ch).set(1,i);
        }
        int e=-1,st=-1;
        for(int i=0;i<s.length();i++){
            if(st==-1) st=map.get(s.charAt(i)).get(0);
            if(e==-1) e=map.get(s.charAt(i)).get(1);
            else if(e>map.get(s.charAt(i)).get(0)) e=Math.max(e,map.get(s.charAt(i)).get(1));
            else{
                ans.add(e-st+1);
                e=-1;st=-1;
                i--;
            }
        }
        ans.add(e-st+1);
        return ans;
    }
}