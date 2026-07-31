class Solution {
    public int splitArray(int[] nums, int k) {
        int lo=0;
        int hi=0;
        for(int num:nums){
            lo=Math.max(lo,num);
            hi+=num;
        }
        int ans=hi;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(canSplit(nums,k,mid)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public boolean canSplit(int[] nums, int k,int minsum){
        int subarray=1;
        int sum=0;
        for(int num:nums){
            if(sum+num<=minsum){
                sum+=num;
            }
            else{
                subarray++;
                sum=num;
            }
        }
        return subarray<=k;
    }
}