class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int mincap=0;
        int maxcap=0;
        for(int weight:weights){
            mincap=Math.max(mincap,weight); // maximum weight
            maxcap+=weight;      // total weight
        }
        int ans=maxcap;
        while(mincap<=maxcap){
            int mid=mincap+(maxcap-mincap)/2;
            if(canship(weights,days,mid)){
                ans=mid;
                maxcap=mid-1; // try smaller capacity
            }
            else{
                mincap=mid+1;   // increase capacity
            }

        }
        return ans;
    }
    public boolean canship(int[] weights, int days,int capcity){
        int useday=1;
        int load=0;
        for(int w:weights){
            if(load+w<=capcity){
                load+=w;
            }
            else{
                useday++;
                load=w;
            }
        }
        return useday<=days;
    }  
}