class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        char[][] arr = new char[strs.length][];
        for(int i=0; i < strs.length; i++) {
            arr[i] = strs[i].toCharArray();
            Arrays.sort(arr[i]);
        }
        
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0;i < strs.length;i++) {
            String str = new String(arr[i]);
            map.putIfAbsent(str, new ArrayList<>());
            map.get(str).add(strs[i]);
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> en: map.values()) {
            ans.add(en);
        }
        return ans;
    }
}