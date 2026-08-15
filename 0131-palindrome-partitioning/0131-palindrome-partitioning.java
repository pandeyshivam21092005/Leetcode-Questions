class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> templist=new ArrayList<>();
        backtrack(s,ans,templist,0);
        return ans;
    }
    private void backtrack(String s,List<List<String>> ans,List<String> templist,int start){
        // Base case
        if(start==s.length()){
            ans.add(new ArrayList<>(templist));
            return;
        }
        // Try every possible substring
        for(int i=start;i<s.length();i++){
            if(isPalindrome(s,start,i)){
                // Choose
                templist.add(s.substring(start,i+1));
                 // Explore
                backtrack(s,ans,templist,i+1);
                // Backtrack
                templist.remove(templist.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s,int left,int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}