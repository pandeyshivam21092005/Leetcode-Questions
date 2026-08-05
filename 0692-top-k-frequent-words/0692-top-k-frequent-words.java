class Pair implements Comparable<Pair>{
    String ele;
    int freq;
    Pair(String ele,int freq){
        this.ele=ele;
        this.freq=freq;
    }
    @Override
    public int compareTo(Pair p){
         if (this.freq != p.freq) {
            return this.freq - p.freq;
        }
         return p.ele.compareTo(this.ele);
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
       HashMap<String,Integer> map=new HashMap<>();
       for(String ele:words){
        map.put(ele,map.getOrDefault(ele,0)+1);
       }
       PriorityQueue<Pair> pq=new PriorityQueue<>();
       for(String ele:map.keySet()){
        int freq=map.get(ele);
        pq.add(new Pair(ele,freq));
        if(pq.size()>k) pq.remove();
       }
       List<String> ans=new ArrayList<>();
       while(!pq.isEmpty()){
        ans.add(pq.remove().ele);
       }
       Collections.reverse(ans);
       return ans;
    }
}