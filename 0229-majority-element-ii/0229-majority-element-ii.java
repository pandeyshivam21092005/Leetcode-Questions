class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int n=nums.length;

        int count1=0;
        int count2=0;
        int candidate1=0;
        int candidate2=0;
        // Step 1: Find two possible candidates
        for(int num:nums){
            if(num==candidate1){
                count1++;
            }
            else if(num==candidate2){
                count2++;
            }
            else if(count1==0){
                candidate1=num;
                count1=1;
            }
             else if(count2==0){
                candidate2=num;
                count2=1;
            }
            else{
                count1--;
                count2--;
            }

        }
         // Step 2: Verify candidates
         count1=0;
         count2=0;

          for(int num:nums){
            if(num==candidate1){
                count1++;
            }
            else if(num==candidate2){
                count2++;
            }
          }  

          if(count1>n/3){
            ans.add(candidate1);
          }
         if(count2>n/3){
            ans.add(candidate2);
          }
          return ans; 
    }
}