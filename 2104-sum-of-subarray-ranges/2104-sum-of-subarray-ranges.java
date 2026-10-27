class Solution {
    public long subArrayRanges(int[] nums) {
       return sumSubarrayMax(nums)-sumSubarrayMin(nums); 
    }

    // Minimum number in subarray
    private long sumSubarrayMin(int[] nums){
        int n=nums.length;
        long sum=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n||nums[st.peek()]>=nums[i])){
                int mid=st.pop();
                int left=st.isEmpty()?-1:st.peek();
                int right=i;

                long leftCount=mid-left;
                long rightCount=right-mid;

                sum+=(long)nums[mid]*leftCount*rightCount;
            }
            if(i<n){
                st.push(i);
            }
        }
         return sum;
    }

     // Maximum number in subarray;
     private long sumSubarrayMax(int[] nums){
        int n=nums.length;
        long sum=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n||nums[st.peek()]<=nums[i])){
                int mid=st.pop();
                int left=st.isEmpty()?-1:st.peek();
                int right=i;

                long leftCount=mid-left;
                long rightCount=right-mid;

                sum+=(long)nums[mid]*leftCount*rightCount;
            }
            if(i<n){
                st.push(i);
            }
        }
         return sum;
    }
}