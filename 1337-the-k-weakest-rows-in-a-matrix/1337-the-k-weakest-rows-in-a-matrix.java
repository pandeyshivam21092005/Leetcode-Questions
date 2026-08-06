class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq= new PriorityQueue<>(
            (a,b)->{
                if(a[0]==b[0]){
                    return a[1]-b[1];
                }
                return a[0]-b[0];
            }
        );
        for(int i=0;i<mat.length;i++){
            pq.add(new int[]{countSolider(mat[i]),i});
        }
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.remove()[1];
        }
        return ans;        
    }
    public int countSolider(int[]row){
        int lo=0;
        int hi=row.length;
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            if(row[mid]==1) lo=mid+1;
            else hi=mid;
        }
        return lo;
    }
}