class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;
        for(int i=0;i<row;i++){
            if(target<matrix[i][0]||target>matrix[i][col-1]) continue;
            int lo=0;
            int hi=col-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(matrix[i][mid]==target) return true;
            else if(matrix[i][mid]<target) lo=mid+1;
            else hi=mid-1;
        }
        }
        return false;
    }
}