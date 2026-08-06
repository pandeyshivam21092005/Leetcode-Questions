class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(
            (a,b)->{
                int diff1=Math.abs(a-x);
                int diff2=Math.abs(b-x);
                if(diff1==diff2){
                    return b-a;   // larger element first
                }
                return diff2-diff1;   // larger distance first
            }
        );
        for(int num:arr){
            pq.add(num);

            if(pq.size()>k) pq.remove();
        }
        List<Integer> ans= new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.remove());
        }
        Collections.sort(ans);
        return ans;
    }
}