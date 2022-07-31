class NumArray {
    int[] seg, arr;
    int n;
    private void build(int ind, int low, int high) {
        if(low == high) {
            seg[ind] = arr[low];
            return ;
        }
        
        int mid = low + (high - low)/2;
        build(2*ind + 1, low, mid);
        build(2*ind + 2, mid + 1, high);
        
        seg[ind] = seg[2*ind + 1] + seg[2*ind+2];
    }
    private void update(int ind, int low, int high, int i, int val) {
        if(low == high) {
            seg[ind] = val;
            return;
        }
        
        int mid = low + (high - low)/2;
        if(i <= mid) update(2*ind + 1, low, mid, i, val);
        else update(2*ind + 2, mid + 1, high, i, val);
        
        seg[ind] = seg[2*ind + 1] + seg[2*ind + 2];
    }
    private int query(int ind, int low, int high, int l, int r) {
        //no over lap -> [l r] [low high] || [low high] [l r]
        if(r < low || high < l) return 0;
        
        //complete overlap [l low high r] 
        if(l <= low && high <= r) return seg[ind];
        
        // partial overlap
        int mid = low + (high - low)/2;
        int left = query(2*ind + 1, low, mid, l, r);
        int right = query(2*ind + 2, mid + 1, high, l, r);
        return left + right;
    }
    public NumArray(int[] nums) {
        n = nums.length;
        arr = nums;
        seg = new int[4*n + 1];
        build(0, 0, n-1);
    }
    
    public void update(int index, int val) {
        arr[index] = val;
        update(0, 0, n - 1, index, val);
    }
    
    public int sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */