class ATM {
    long notes[];
    int values[] = {20,50,100,200,500};
    public ATM() {
        notes = new long[5];
        Arrays.fill(notes,0);
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i=0;i<5;i++) 
            notes[i]=notes[i]+banknotesCount[i];
    }
    
    public int[] withdraw(int amount) {
        int origamount=amount;
        for(int i=4;i>=0;i--){
            int val = values[i];
            amount-=val*Math.min(notes[i],amount/val);
        }
        if(amount!=0) return new int[]{-1};
        
        amount=origamount;
        int ans[] = new int[5];
        for(int i=4;i>=0;i--){
            int reqnotes = amount/values[i];
            ans[i]=(int)((notes[i]>=reqnotes)?reqnotes:notes[i]);
            notes[i]=(notes[i]>reqnotes)?notes[i]-reqnotes:0;
            amount-=ans[i]*values[i];
        }
        return ans;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */