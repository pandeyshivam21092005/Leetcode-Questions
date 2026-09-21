class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo=1;
        int hi=0;
        // Find maximum element
        for(int num:nums){
            hi=Math.max(hi,num);
        }
        int ans=hi;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            int sum=0;
            for(int num:nums){
                // ceil(num / mid)
                sum+=(num+mid-1)/mid;
            }
            if(sum<=threshold){
                // mid works, try smaller divisor
                ans=mid;
                hi=mid-1;
            }
            else{
                 // mid is too small
                lo=mid+1;
            }
        }
        return ans;

    }
}