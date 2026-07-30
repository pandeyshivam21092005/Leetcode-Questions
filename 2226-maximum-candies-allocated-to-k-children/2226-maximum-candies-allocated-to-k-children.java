class Solution {
    public int maximumCandies(int[] candies, long k) {
        int lo=1;
        int hi=0;
        for(int candy: candies){
            hi=Math.max(hi,candy);
        }
         int ans=0;
         while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(canAllocate(candies,k,mid)){
                ans=mid;
                lo=mid+1;   // try bigger answer
            }
            else{
                hi=mid-1;
            }
         }
         return ans;

    }
    public boolean canAllocate(int[] candies, long k,int x){
        long count=0;
        for(int piles:candies){
            count+=piles/x;
            if(count>=k) return true;
        }
        return false;
    }
}