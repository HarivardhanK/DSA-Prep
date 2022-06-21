class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int max = Math.max(v1.length, v2.length);
        for(int i = 0; i < max; i++) {
            int ele1 = (i < v1.length)?Integer.parseInt(v1[i]):0;
            int ele2 = (i < v2.length)?Integer.parseInt(v2[i]):0;
            int diff = ele1 - ele2;
            if(diff > 0)
                return 1;
            else if(diff < 0) 
                return -1;
        }
        
        return 0;
    }
}