class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0) return true;
        if(flowerbed.length==1) return flowerbed[0]==0; 
        if(flowerbed.length==2){
            if(flowerbed[0]==1 || flowerbed[1]==1) return false;
            else if(n==1) return true;
            return false;
        }
        if(flowerbed[0]==0 && flowerbed[1]==0) {
            flowerbed[0]=1;
            n--;
        } 
        for(int i=1;i<flowerbed.length-1;i++){
            if(flowerbed[i]==0 && flowerbed[i-1]==0 && flowerbed[i+1]==0){
                flowerbed[i]=1;
                n--;
            }
            if(n==0) return true;
        }
        if(n!=0 && flowerbed[flowerbed.length-1]==0 && flowerbed[flowerbed.length-2]==0) {
            flowerbed[0]=1;
            n--;
        }
        return n==0;
    }
}