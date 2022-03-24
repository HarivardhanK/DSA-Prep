class Solution {
    //The approach for this problem is to instead of going from start to target we will go from target to start which makes our base case simpler
    //Time complexity is O(logn) because every time it becomes odd the next time it becomes the even 
    public int brokenCalc(int startValue, int target) {
        if(startValue>=target) return startValue-target;//if target is less than or equal to the start we just return the difference between them because to avoid extra recursive calls it is of waste
        if(target%2==0)
            return 1+brokenCalc(startValue,target/2);
        return 1+brokenCalc(startValue,target+1);
    }
}