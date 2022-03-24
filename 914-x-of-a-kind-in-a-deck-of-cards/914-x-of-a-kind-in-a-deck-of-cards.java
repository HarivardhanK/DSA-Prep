class Solution {
    public int gcd(int a, int b){
        return a==0?b:gcd(b%a,a);
    }
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<deck.length;i++){
            map.put(deck[i],map.getOrDefault(deck[i],0)+1);
        }
        int res=map.get(deck[0]);
        for(int val:map.values()){
            res=gcd(res,val);
            if(res==1) return false;
        }
        return true;
    }
}