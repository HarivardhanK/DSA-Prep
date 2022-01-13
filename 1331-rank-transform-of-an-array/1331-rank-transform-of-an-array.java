class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int a[] = new int[arr.length];
        for(int i=0;i<arr.length;i++) a[i]=arr[i];
        Arrays.sort(a);
        HashMap<Integer,Integer> map = new HashMap<>();
        int rank=1;
        for(int i=0;i<a.length;i++) 
            if(!map.containsKey(a[i]))
                map.put(a[i],rank++);
        for(int i=0;i<a.length;i++) arr[i]=map.get(arr[i]);
        return arr;
    }
}