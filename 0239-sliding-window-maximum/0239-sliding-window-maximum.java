class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int [] ans=new int [n-k+1];
        Stack<Integer> st=new Stack<>();
        int idx=0;

        for(int i=0;i<n;i++){

            // Remove indices outside the window
            while(!st.isEmpty()&& st.get(0)<=i-k){
                st.remove(0);
            }

            // Remove smaller elements
            while(!st.isEmpty()&& nums[st.peek()]<=nums[i]){
                st.pop();
            }

            st.push(i);

            if(i>=k-1){
                ans[idx++]=nums[st.get(0)];
            }
        }
        return ans;
    }
}