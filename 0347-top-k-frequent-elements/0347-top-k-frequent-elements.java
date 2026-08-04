class Pair implements Comparable<Pair>{
    int ele;
    int freq;
    Pair(int ele,int freq){
        this.ele=ele;
        this.freq=freq;
    }
    public int compareTo(Pair p){
        if(this.freq==p.freq) return this.ele-p.ele;
        return this.freq-p.freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] arr, int k) {
       HashMap<Integer,Integer> map=new HashMap<>();
       for(int a:arr){
        map.put(a,map.getOrDefault(a,0)+1);
       }
       PriorityQueue<Pair>pq=new PriorityQueue<>();
       for(int ele:map.keySet()){
        int freq=map.get(ele);
        pq.add(new Pair(ele,freq));
        if(pq.size()>k) pq.remove();
       }
       int[] ans=new int[k];
       for(int i=k-1;i>=0;i--){
        ans[i]=pq.remove().ele;
       }
       return ans; 
    }
}