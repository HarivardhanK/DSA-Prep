class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int max=0;
        for(int i=0,j=0;j<fruits.length;j++){
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
            if(map.size()<=2){
                max=Math.max(max,j-i+1);
            }
            else{
                while(map.size()>2){
                    map.put(fruits[i],map.get(fruits[i])-1);
                    if(map.get(fruits[i])==0) map.remove(fruits[i]);
                    i++;
                }
            }
        }
        return max;
    }
}