class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=0;
        for(int pile:piles){
            right=Math.max(right,pile);
        }
        while(left<right){
            int mid=left+(right-left)/2;
            int hour=0;
             // Calculate total hours needed at speed = mid
            for(int p:piles){
                hour+=(p+mid-1)/mid; // ceil(pile / mid)

            }
            if(hour<=h){
                right=mid; // Try a smaller speed
            }
            else{
                left=mid+1; // Increase the speed
            }
        }
        return left;
    }
}