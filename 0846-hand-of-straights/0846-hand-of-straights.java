class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0){
            return false;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:hand){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        pq.addAll(map.keySet());
        while(!pq.isEmpty()){
            int first=pq.peek();
            for(int i=0;i<groupSize;i++){
                int num=first+i;

                if(!map.containsKey(num)){
                    return false;
                }
                map.put(num,map.get(num)-1);

                if(map.get(num)==0){
                    map.remove(num);

                    if(pq.peek()==num){
                    pq.remove();
                  }
                }
            }
        }
        return true;
    }
}