class Solution {
    private List<String> digitToString(char digit){
        switch(digit){
            case '2': return new ArrayList<>(Arrays.asList("a","b","c"));
            case '3': return new ArrayList<>(Arrays.asList("d","e","f"));
            case '4': return new ArrayList<>(Arrays.asList("g","h","i"));
            case '5': return new ArrayList<>(Arrays.asList("j","k","l"));
            case '6': return new ArrayList<>(Arrays.asList("m","n","o"));
            case '7': return new ArrayList<>(Arrays.asList("p","q","r","s"));
            case '8': return new ArrayList<>(Arrays.asList("t","u","v"));
            case '9': return new ArrayList<>(Arrays.asList("w","x","y","z"));
        }
        return new ArrayList<>();
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        for(int i=0;i<digits.length();i++){
            List<String> arr = digitToString(digits.charAt(i));
            if(ans.size()==0){
                ans = arr;
            }
            else{
                List<String> smallans = new ArrayList<>();
                for(int j=0;j<ans.size();j++){
                    for(int k=0;k<arr.size();k++){
                        smallans.add(ans.get(j)+arr.get(k));
                    }
                }
                ans = smallans;
            }
        }
        return ans;
    }
}