class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(ans,new ArrayList<>(),candidates,target,0);
        return ans;
    }
    private void backtrack(List<List<Integer>> ans,List<Integer> temp,int[]nums,int target,int start){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<nums.length;i++){
            // Skip duplicates at the same level
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
             // Since array is sorted
            if(nums[i]>target){
                break;
            }
            temp.add(nums[i]);

            // i + 1 because each element can be used only once
            backtrack(ans,temp,nums,target-nums[i],i+1);
            temp.remove(temp.size()-1);
        }
    }
}