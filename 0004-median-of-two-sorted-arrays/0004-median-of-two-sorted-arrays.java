class Solution {
    public double findMedianSortedArrays(int[] num1, int[] num2) {
        if (num1.length > num2.length){
            return findMedianSortedArrays(num2, num1);
        }
        int[] smaller = num1;
        int[] larger = num2;
        int totalLength=num1.length+num2.length;
        int lo=0;
        int hi=smaller.length;
        while(lo<=hi){
            int partitionX=(lo+hi)/2;
            int partitionY=(totalLength+1)/2-partitionX;
            int l1=partitionX==0?Integer.MIN_VALUE: smaller[partitionX-1];
            int r1=partitionX==smaller.length?Integer.MAX_VALUE: smaller[partitionX];
            int l2=partitionY==0?Integer.MIN_VALUE: larger[partitionY-1];
            int r2=partitionY==larger.length?Integer.MAX_VALUE: larger[partitionY];
            if(l1<=r2&&l2<=r1){
                if((totalLength)%2==0){
                    return(Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
                else{
                    return Math.max(l1,l2);
                }
            }
            else if(l1>r2)hi=partitionX-1;
            else lo=partitionX+1;
        }
        return 0;
    }
}