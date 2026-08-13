class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList=new ArrayList<>();
        backtrack(resultList,new ArrayList<>(),nums);
        return resultList;
    }
    private void backtrack(List<List<Integer>> resultList,ArrayList<Integer> tempList,int[] nums){
        // if we match the length,it is a permutation
        if(tempList.size()==nums.length){
            resultList.add(new ArrayList<>(tempList));
            return;
        }
        for(int num:nums){
            // skip if we get same element
            if(tempList.contains(num)) continue;
            // add the new element
            tempList.add(num);
            // Go baack to try another element
            backtrack(resultList,tempList,nums);
            // remove the element
            tempList.remove(tempList.size()-1);
        }
    }
}