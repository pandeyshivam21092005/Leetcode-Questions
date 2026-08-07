class Solution {
    public int leastInterval(char[] tasks, int n) {
          // 1. Count frequency using HashMap
        HashMap<Character,Integer> map= new HashMap<>();
        for(char ch:tasks){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        // 2. Max Heap based on frequency
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int freq:map.values()){
            pq.add(freq);
        }
        int time=0;
        // 3. Process tasks in cycles of size n + 1
        while(!pq.isEmpty()){
            int cycle=n+1;
            List<Integer> temp=new ArrayList<>();
            while(cycle>0&&!pq.isEmpty()){
                int freq=pq.remove();
                freq--;
                if(freq>0) temp.add(freq);
                time++;
                cycle--;
            }
            // Put remaining frequencies back
            for(int freq:temp){
                pq.add(freq);
            }
             // If heap is not empty, remaining cycle slots are idl
            if(!pq.isEmpty()){
                time+=cycle;
            }
        }
        return time;
    }
}