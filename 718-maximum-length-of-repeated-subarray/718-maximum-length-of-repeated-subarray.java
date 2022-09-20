class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        // Set<String> set = new HashSet<>();
        // for(int i = 0;i < nums1.length; i++) {
        //     String str = "";
        //     for(int j = i; j < nums1.length; j++) {
        //         str +=" "+nums1[j];
        //         set.add(str);
        //     }
        // }
        // int max =0;
        // for(int i = 0; i < nums2.length; i++) {
        //     String str = "";
        //     for(int j = i; j < nums2.length; j++) {
        //         str += " "+nums2[j];
        //         if(set.contains(str)) max = Math.max(str.split(" ").length, max);
        //     }
        // }
        // return Math.max(0,max-1);
        int n1 = nums1.length, n2 = nums2.length;
        int max = 0;
        int[][] dp = new int[n1][n2];
        for(int i = 0; i < n1; i++) {
            for(int j = 0; j < n2; j++) {
                if(nums1[i] == nums2[j]){ 
                    dp[i][j]++;
                    if(i != 0 && j != 0) 
                        dp[i][j] += dp[i-1][j-1];
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}

// 0 0 1 0 0
// 0 1 0 0 0
// 1 0 0 0 0
// 0 2 0 0 0
// 0 0 3 0 0

// 0 1 0 1 0
// 1 0 2 0 1
// 1 0 1 0 1
// 1 0 1 0 1
// 1 0 1 0 1