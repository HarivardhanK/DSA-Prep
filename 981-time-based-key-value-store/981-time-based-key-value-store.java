class TimeMap {
    Map<String, List<String[]>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new String[]{timestamp+"", value});
    }
    
    public String get(String key, int timestamp) {
        // return binsearch(key, timestamp+"");
        return bs(key, timestamp);
    }
    private String bs(String key, int ts) {
        if(!map.containsKey(key)) return "";
        else if(map.get(key).size() >= 1) {
            Integer pts = Integer.parseInt(map.get(key).get(0)[0]);
            if(map.get(key).size() == 1 && pts <= ts) return map.get(key).get(0)[1];
            else if(pts > ts) return "";
        }
        List<String[]> arr = map.get(key);
        int lo = 0, hi = arr.size()-1;
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            Integer pts = Integer.parseInt(arr.get(mid)[0]);
            if(pts == ts) return arr.get(mid)[1];
            else if(pts > ts) hi = mid-1;
            else lo = mid+1;
        }
        return arr.get(hi)[1];
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */