class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for(String path: paths) {
            String[] parr = path.split(" ");
            String dir = parr[0];
            for(int i = 1; i < parr.length; i++) {
                int start = 0;
                while(start < parr[i].length() && parr[i].charAt(start) != '(') start++;
                String content = parr[i].substring(start+1, parr[i].length()-1);
                if(!map.containsKey(content)) map.put(content, new ArrayList<>());
                map.get(content).add(dir+"/"+parr[i].substring(0, start));
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> en: map.entrySet()) {
            if(en.getValue().size() > 1) {
                ans.add(en.getValue());
            }
        }
        return ans;
    }
}