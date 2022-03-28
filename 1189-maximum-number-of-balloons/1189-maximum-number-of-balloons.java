class Solution {
    public int maxNumberOfBalloons(String text) {
        int arr[] = new int[5];
        for(char c:text.toCharArray()){
            switch (c){
                case 'b':arr[0]+=1; break;
                case 'a':arr[1]+=1; break;
                case 'l':arr[2]+=1; break;
                case 'o':arr[3]+=1; break;
                case 'n':arr[4]+=1; break;
            }
        }
        int ans = 0;
        while(arr[0]>0 && arr[1]>0 && arr[2]>1 && arr[3]>1 && arr[4]>0){
            ans++;
            arr[0]=arr[0]-1;
            arr[1]=arr[1]-1;
            arr[2]=arr[2]-2;
            arr[3]=arr[3]-2;
            arr[4]=arr[4]-1;
        }
        return ans;
    }
}