class Pair{
    char ch;
    int freq;
    Pair(char ch,int freq){
        this.ch=ch;
        this.freq=freq;
    }
}
class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        // Count frequency
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        // Max heap based on frequency
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.freq-a.freq);
        // Put characters into heap
        for (Map.Entry<Character, Integer> ele : map.entrySet()) {
            if (ele.getValue() > (s.length() + 1) / 2) {
                return "";
            }
            pq.add(new Pair(ele.getKey(), ele.getValue()));
        }
        StringBuilder ans=new StringBuilder ();
         // Take two most frequent characters
        while(pq.size()>1){
            Pair first=pq.remove();
            Pair second=pq.remove();

            ans.append(first.ch);
            ans.append(second.ch);

            first.freq--;
            second.freq--;

            if(first.freq>0){
                pq.add(first);
            }
            if(second.freq>0){
                pq.add(second);
            }
        }
        // Handle remaining character
        while(!pq.isEmpty()){
            Pair last=pq.remove();
            if(last.freq>1) return "";
            ans.append(last.ch);
        }
        return ans.toString();
    }
}