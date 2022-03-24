class Solution {
    private int gcd(int a, int b){
        return a==0?b:gcd(b%a,a);
    }
    private String simfra(int a, int b){
        int gcd=gcd(a,b);
        return a/gcd + "/" + (b/gcd);
    }
    public List<String> simplifiedFractions(int n) {
        Set<String> set = new HashSet<>();
        for(int i=1;i<n;i++){
            for(int j=i+1;j<=n;j++){
                String s = simfra(i,j);
                set.add(s);
            }
            
        }
        return new ArrayList<String>(set);
    }
}