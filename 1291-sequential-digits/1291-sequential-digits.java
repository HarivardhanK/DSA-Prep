class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        int num=low;
        int nodigl=1, nodigu=1;
        while(num>0){
            nodigl++;
            num/=10;
        }
        num = high;
        while(num>0){
            nodigu++;
            num/=10;
        }
        String s="";
        for(int i=nodigl;i<=nodigu;i++){
            s="";
            for(int j=1;j<i && j<10;j++) s+=j;
            if(Integer.parseInt(s)<=high && Integer.parseInt(s)>=low) ans.add(Integer.parseInt(s));
            if(i==10) break;
            for(int j=i;j<=9;j++){
                s=s.substring(1)+j;
                if(Integer.parseInt(s)<=high && Integer.parseInt(s)>=low) ans.add(Integer.parseInt(s));
            }
        }
        return ans;
    }
}