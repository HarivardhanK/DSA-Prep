class Solution {
    public String pushDominoes(String dominoes) {
        int cnt = 0, n = dominoes.length();
        int[] nearestright = new int[n];
        int[] nearestleft = new int[n];
        if(dominoes.charAt(0) == 'R') nearestright[0] = 0;
        else nearestright[0] = -1;
        for(int i = 1;i < n; i++) {
            if(dominoes.charAt(i) == 'R')
                nearestright[i] = i;
            else if(dominoes.charAt(i) == 'L') 
                nearestright[i] = -1;
            else 
                nearestright[i] = nearestright[i-1];
        }
        
        if(dominoes.charAt(n-1) == 'L') nearestleft[n-1] = n-1;
        else nearestleft[n-1] = -1;
        for(int i = n-2;i >= 0; i--) {
            if(dominoes.charAt(i) == 'L') 
                nearestleft[i] = i;
            else if(dominoes.charAt(i) == 'R') 
                nearestleft[i] = -1;
            else 
                nearestleft[i] = nearestleft[i+1];
        }
        // System.out.println(Arrays.toString(nearestright));
        // System.out.println(Arrays.toString(nearestleft));
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < n; i++) {
            if(nearestleft[i] == -1 && nearestright[i] == -1) 
                sb.append(".");
            else if(nearestleft[i] == -1 && nearestright[i] != -1)
                sb.append("R");
            else if(nearestleft[i] != -1 && nearestright[i] == -1) 
                sb.append("L");
            else {
                if(i-nearestright[i] == nearestleft[i]-i) 
                    sb.append(".");
                else if(i-nearestright[i] < nearestleft[i]-i)
                    sb.append("R");
                else sb.append("L");
            }
        }
        
        return sb.toString();
        // 0 1 2 3 4 5 6 7 8 9 10111213
        // . L . R . . . L R . . L . .
        //[-1 -1 -1 3 3 3 3 3 8  8  8  8  8  8]
        //[1   1 7  7 7 7 7 7 11 11 11 11 -1 -1]
    }
}

//L.R
// 0 1 2
// 1 1 0