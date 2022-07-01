
/*
 [[1,3],[2,2],[3,1]] truckSize = 4 -> max no. of boxes can fit
 [no.ofBoxes, numberOfunitsperbox] -> maximize no. of units
 
 [[5,10],[2,5],[4,7],[3,9]], truckSize = 10  op: 91
 sort according to the units ie arr[i][1]
 [[5,10],[3,9],[4,7],[2,5]] 
 pick as many as we can 
 5*10 + 3*9 + 2*7 = 50 + 27 + 14 = 91
 
*/
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        
        int maxUnits = 0;
        for(int box[]: boxTypes) {
            int taken = (truckSize < box[0])?truckSize:box[0];
            maxUnits += taken * box[1];
            truckSize -= box[0];
            if(truckSize <= 0) break;
        }
        
        return maxUnits;
    }
}

