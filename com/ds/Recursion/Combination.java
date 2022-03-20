package com.ds.Recursion;
class Combination {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        helper(n,k,result, new ArrayList<>(),1);
        
        return result;
    }
    
    public void helper(int n, int k, List<List<Integer>> result, List<Integer> currentList, int index){
        
        if(currentList.size() == k){
              result.add(new ArrayList<>(currentList));
              return;
            
            }
        
        for(int i = index; i <= n ; i++ ){
           
            currentList.add(i);
            helper(n, k, result,currentList, i+1);
            currentList.remove(currentList.size()-1);
            
        }
      
    }
}