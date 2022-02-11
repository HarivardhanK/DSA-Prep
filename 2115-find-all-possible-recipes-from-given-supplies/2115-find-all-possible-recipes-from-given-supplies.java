class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<supplies.length;i++) set.add(supplies[i]);
        List<String> ans = new ArrayList<>();
        boolean found=true;
        while(found){
            found=false;
            for(int i=0;i<recipes.length;i++){
                if(set.contains(recipes[i])) continue;
                boolean isRecipe=true;
                for(String str:ingredients.get(i)){
                    if(!set.contains(str)){
                        isRecipe=false;
                        break;
                    }
                }
                if(isRecipe){
                    ans.add(recipes[i]);
                    set.add(recipes[i]);
                    found=true;
                }
            }
        }
        
        return ans;
    }
}