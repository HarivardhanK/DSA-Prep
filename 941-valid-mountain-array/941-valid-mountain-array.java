class Solution {
    public boolean validMountainArray(int[] arr) {
        int i=1;
        boolean up=false,down=false;
        while(i<arr.length && arr[i-1]<=arr[i]){
            if(arr[i-1]==arr[i]){
                return false;
            }
            up=true;
            i++;
        }
        while(i<arr.length && arr[i-1]>=arr[i] ){
            if(arr[i-1]==arr[i]){
                return false;
            }
            down=true;
            i++;
        }
        if(up && down && i==arr.length){
            return true;
        }
        return false;
    }
}