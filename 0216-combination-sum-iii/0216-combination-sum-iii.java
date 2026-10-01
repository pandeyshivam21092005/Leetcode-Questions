class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        backtrack(1,k,n,ans,curr);
        return ans;
    }
    private void backtrack(int idx,int k, int n,List<List<Integer>> ans,List<Integer> curr){
        if(curr.size()==k){
            if(n==0){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        for(int i=idx;i<=9;i++){
            if(i>n) break;

            curr.add(i);
            backtrack(i+1,k,n-i,ans,curr);
            curr.remove(curr.size()-1);
        }
    }
}