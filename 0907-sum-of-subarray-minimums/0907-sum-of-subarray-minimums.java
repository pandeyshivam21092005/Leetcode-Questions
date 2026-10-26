class Solution {
    public int sumSubarrayMins(int[] arr) {
        long mod=1000000007;
        int n=arr.length;
        long sum=0;
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<=n;i++){
            while(!st.isEmpty()&&(i==n||arr[st.peek()]>=arr[i])){
                int mid=st.pop();
                int left=st.isEmpty()?-1:st.peek();
                int right=i;

                long leftCount=mid-left;
                long rightCount=right-mid;

                sum=(sum+arr[mid]*leftCount*rightCount)%mod;
            }
            if(i<n){
                st.push(i);
            }
        }
        return (int) sum;
    }
}