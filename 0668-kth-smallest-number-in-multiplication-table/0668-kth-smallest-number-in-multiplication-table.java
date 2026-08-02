class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lo=1;
        int hi=m*n;
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            if(count(mid,m,n)<k) lo=mid+1;
            else hi=mid;
        }
        return lo;
    }

    public int count(int x,int m,int n){
        int cnt=0;
        for(int i=1;i<=m;i++){
            cnt+=Math.min(x/i,n);
        }
        return cnt;
    }
}