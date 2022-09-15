class Solution {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        if(changed.length%2 != 0) return new int[]{};
        int[] ans = new int[changed.length/2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int ele: changed) {
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        int ind = 0;
        for(int ele: changed) {
            if(map.get(ele) > 0) {
                int mult = ele*2, div; 
                if(ele%2==0 && ele != 0) div = ele/2;
                else div = -1;
                
                if(map.containsKey(mult) && map.get(mult) > 0) {
                    map.put(mult, map.get(mult)-1);
                    map.put(ele, map.get(ele)-1);
                    ans[ind++] = ele;
                }
                else if(map.containsKey(div) && map.get(div) > 0) {
                    map.put(div, map.get(div)-1);
                    map.put(ele, map.get(ele)-1);
                    ans[ind++] = div;
                }
                else return new int[]{};
            }
        }
        return ans;
    }
}

// [1,2,8,4,16,8]