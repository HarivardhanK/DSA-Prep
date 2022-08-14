class Solution {
    private Set<String> dict;
    private String beginWord;
    private String endWord;
    
    // Key: String  Value: parents in the sense that close to beginWord/endWord;
    private Map<String, List<String>> forwardMap = new HashMap<>(); 
    private Map<String, List<String>> backwardMap = new HashMap<>(); 
    
    // Key: String (always appears in a path)  Value: list of String that could be the next String in some paths
    private Map<String, List<String>> pathMap = new HashMap<>();
    
    private Set<String> intersect;
    
    private List<List<String>> paths = new ArrayList<>();
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.dict = new HashSet(wordList);
        if (!dict.contains(endWord)) return paths;
        
        this.beginWord = beginWord;
        this.endWord = endWord;
        
        this.intersect = buildMaps();
        if (intersect.size() == 0) return paths;
        
        trimForwardMap();
        trimBackwardMap();
        
        List<String> curr = new ArrayList<>();
        curr.add(beginWord);
        collectAllPaths(beginWord, curr);
        
        return paths;
    }
    
    private void collectAllPaths(String s, List<String> curr) {
        if (s.equals(endWord)) {
            paths.add(new ArrayList(curr));
            return;
        }
        
        for (String next : pathMap.get(s)) {
            curr.add(next);
            collectAllPaths(next, curr);
            curr.remove(curr.size() - 1);
        }
        
    }
    
    
    private Set<String> buildMaps() {
        Set<String> forward = new HashSet<>();
        forward.add(beginWord);
        
        Set<String> backward = new HashSet<>();
        backward.add(endWord);
        
        Set<String> visited = new HashSet<>();
        Set<String> intersect = new HashSet<>();
       
        boolean found = false;
        boolean reverse = false;   
        
     
        while(!forward.isEmpty() && !found) {
            if (forward.size() > backward.size()) {
                Set<String> temp = forward;
                forward = backward;
                backward = temp;
                reverse = !reverse;
            }
            
            Set<String> temp = new HashSet<>(); 
            
            for (String s : forward) {
                visited.add(s);
                
                for (String next : getNext(s)) {
                    if (forward.contains(next) || visited.contains(next)) continue;
                    if (backward.contains(next)) {
                        found = true;
                        intersect.add(next);
                    }
                    
                    temp.add(next);
                    
                    if (reverse) {
                        backwardMap.putIfAbsent(next, new ArrayList<>());
                        backwardMap.get(next).add(s);
                    } else {
                        forwardMap.putIfAbsent(next, new ArrayList<>());
                        forwardMap.get(next).add(s);
                    }
                }
            }
            
            forward = temp;
        }
      
        return intersect;
    }
    
    private void trimForwardMap() {
        Deque<String> queue = new LinkedList<>();
        intersect.stream().forEach(s -> queue.offerLast(s));
        
        Set<String> visited = new HashSet(intersect);
        
        while (!queue.isEmpty()) {
            String s = queue.pollFirst();
            if (!forwardMap.containsKey(s)) return;   // reach beginword
            
            for (String p : forwardMap.get(s)) {
                pathMap.putIfAbsent(p, new ArrayList<>());
                pathMap.get(p).add(s);
                
                if (visited.add(p)) queue.offerLast(p);
            }
        }
        return;
    }
    
    private void trimBackwardMap() {
        Deque<String> queue = new LinkedList<>();
        intersect.stream().forEach(s -> queue.offerLast(s));
        
        Set<String> visited = new HashSet(intersect);
        
        while (!queue.isEmpty()) {
            String s = queue.pollFirst();
            if (!backwardMap.containsKey(s)) return;   // reach endWord
            
            for (String d : backwardMap.get(s)) {
                pathMap.putIfAbsent(s, new ArrayList<>());
                pathMap.get(s).add(d);
                
                if (visited.add(d)) queue.offerLast(d);
            }
        }
        return;
    }
    
    private List<String> getNext(String s) {
        char[] arr = s.toCharArray();
        List<String> nbs = new ArrayList<>();
   
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == ch) continue;
                arr[i] = c;
                String nb = new String(arr);
                if (dict.contains(nb)) nbs.add(nb);
            }
            arr[i] = ch;
        }
        
        return nbs;
    }
}