class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int rows=mat.length;
        int col=mat[0].length;

        int lo=0;
        int hi=col-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            // Find maximum element in this colum
            int maxrow=0;
            for(int i=0;i<rows;i++){
                if(mat[i][mid]>mat[maxrow][mid]){
                    maxrow=i;
                }
            }
            int left=(mid>0)? mat[maxrow][mid-1]:-1;
            int right=(mid<col-1)? mat[maxrow][mid+1]:-1;

            // Peak found
            if(mat[maxrow][mid]>left && mat[maxrow][mid]>right){
                return new int []{maxrow,mid};
            }
             // Move towards larger neighbor
            else if(left>mat[maxrow][mid]){
                hi=mid-1;
            }
            else {
                lo=mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}