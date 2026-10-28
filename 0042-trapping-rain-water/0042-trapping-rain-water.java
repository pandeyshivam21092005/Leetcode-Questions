class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int water=0;
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&& height[st.peek()]<height[i]){
                int mid=st.pop();

                if(st.isEmpty()){
                    break;
                }

                int left=st.peek();
                int width=i-left-1;
                int h=Math.min(height[left],height[i])-height[mid];

                water+=width*h;
            }
            st.push(i);
        }
        return water;
    }
}