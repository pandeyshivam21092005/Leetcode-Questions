class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0,ans,curr,nums);
        return ans;
    }
    private void backtrack(int idx,List<List<Integer>> ans,List<Integer> curr,int []nums){
        ans.add(new ArrayList<>(curr));
        for(int i=idx;i<nums.length;i++){
            // Skip duplicate elements at the same level
            if(i>idx && nums[i]==nums[i-1]) continue;
            curr.add(nums[i]);
            backtrack(i+1,ans,curr,nums);
            curr.remove(curr.size()-1);
        }
    }
}