class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        long max_reach=startFuel;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int count=0;
        int index=0;
        while(max_reach<target){
             // Add all stations that we can currently reach
            while(index<stations.length&&stations[index][0]<=max_reach){
                pq.add(stations[index][1]);
                index++;
            }
            // No reachable station left
            if(pq.isEmpty()) return -1;
            // Take maximum fuel
            max_reach+=pq.peek();
            pq.remove();
            count++;
        }
        return count;
    }
}