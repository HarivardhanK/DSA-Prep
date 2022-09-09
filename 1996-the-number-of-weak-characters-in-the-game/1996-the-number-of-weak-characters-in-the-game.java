class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        //sorting the properties based on (small->big)attack
        //if the attacks value is same then (big->small) defence
        Arrays.sort(properties, (a,b)-> (a[0] != b[0])?a[0]-b[0]:b[1]-a[1]);
        
        int ans = 0;
        int maxDef = Integer.MIN_VALUE;
        for(int i = properties.length - 1; i >= 0; i--) {
            if(maxDef > properties[i][1]) ans++;
            maxDef = Math.max(maxDef, properties[i][1]);
        }
        return ans;
    }
}