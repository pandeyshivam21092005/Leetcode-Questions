class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans =new ArrayList<>();

        if(nums1.length==0||nums2.length==0||k==0){
            return ans;
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

         // Add pairs with nums1[i] and nums2[0]
        for(int i=0;i<Math.min(nums1.length,k);i++){
            pq.add(new int[]{nums1[i]+nums2[0],i,0});
        }
        while(k>0&& !pq.isEmpty()){
            int[] curr=pq.remove();

            int sum=curr[0];
            int i=curr[1];
            int j=curr[2];

            ans.add(Arrays.asList(nums1[i],nums2[j]));

             // Move to next element in nums2
            if(j+1<nums2.length){
                pq.add(new int[]{nums1[i]+nums2[j+1],i,j+1});
            }
            k--;
        }
        return ans;
    }
}