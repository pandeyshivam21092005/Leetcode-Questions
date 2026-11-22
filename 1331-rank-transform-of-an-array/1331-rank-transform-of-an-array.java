class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int num:arr){
            pq.add(num);
        }
        int rank=1;

        while(!pq.isEmpty()){
            int num=pq.remove();

            if(!map.containsKey(num)){
                map.put(num,rank);
                rank++;
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=map.get(arr[i]);
        }
        return arr;
    }
}