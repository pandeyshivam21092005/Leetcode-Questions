class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
         // Not enough flowers
        if((long)m*k>bloomDay.length) return -1;

        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        // Find minimum and maximum bloom day
        for(int day:bloomDay){
            low=Math.min(low,day);
            high=Math.max(high,day);
        }
        while(low<high){
            int mid=low+(high-low)/2;
            if(canMake(bloomDay,m,k,mid)){
                high=mid;   // Try smaller day
            }
            else{
                low=mid+1;    // Need more days
            }
        }
        return low;
    }
    public boolean canMake(int[] bloomDay, int m, int k,int day){
        int flowers=0;
        int bouquets=0;
        for(int bloom:bloomDay){
            if(bloom<=day){
                flowers++;
                if(flowers==k){
                    bouquets++;
                    flowers=0;   // Start making next bouquet
                }
            }
            else {
                flowers=0;    // Adjacent flowers broken
            }
        }
        return bouquets>=m;
    }
}