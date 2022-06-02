class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0) 
            return new ArrayList<>();
        
        List<List<Integer>> pasTri = new ArrayList<>();
        //adding first row
        pasTri.add(new ArrayList<>());
        pasTri.get(0).add(1);
        
        for(int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < i + 1; j++){
                if(j == 0 || j == i){
                    row.add(1);
                }
                else{
                    int val = pasTri.get(i-1).get(j-1) + pasTri.get(i-1).get(j);
                    row.add(val);
                }
            }
            pasTri.add(row);
        }
        
        return pasTri;
    }
}


/*
1
1 1
1 2 1 
1 3 3 1


*/