class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //using the two pointers one pointing to the begin and other ot last
        int start = 0, end = numbers.length-1;
        while(start < end){
            int sum = numbers[start] + numbers[end];
            if(sum == target)
                return new int[]{start+1, end+1};
            else if(sum < target)
                start++;
            else
                end--;
        }
        return numbers;
    }
}