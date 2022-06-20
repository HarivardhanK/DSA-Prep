class Solution {
    public int minimumLengthEncoding(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int sum = 0, index = 0, hashCount = 0;
        for(String word: words) {
            if(!map.containsKey(word)) {
                map.put(word, index++);
                sum += word.length();
                hashCount++;
            }
            else{
                words[index] = "";
            }
        }
        String temp = "";
        for(int i = 0; i < words.length; i++ ) {
            for(int j = 0; j < words[i].length(); j++) {
                temp = words[i].substring(j,words[i].length());
                if(map.containsKey(temp) && temp != words[i] && words[map.get(temp)] != "") {
                    words[map.get(temp)] = "";
                    sum -= temp.length();
                    hashCount--;
                }
            }
        }
        return sum + hashCount;
    }
}