class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
         // Add all stones
        for(int stone:stones){
            pq.add(stone);
        }
        // Smash two heaviest stones
        while(pq.size()>1){
            int y=pq.remove(); // heaviest
            int x=pq.remove(); // second heaviest
            if(x!=y){
                pq.add(y-x);
            }
        }
        // No stone -> 0
        // One stone -> its weight
        return pq.isEmpty()?0:pq.peek();
    }
}