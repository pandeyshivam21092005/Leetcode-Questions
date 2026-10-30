class LRUCache {

    int capacity;
    HashMap<Integer,Integer>map;
    Deque<Integer>dq;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        dq=new LinkedList<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        dq.remove(key);
        dq.addFirst(key);

        return map.get(key);
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            dq.remove(key);
        }
        else if(map.size()==capacity){
            int lru=dq.removeLast();
            map.remove(lru);
        }
        map.put(key,value);
        dq.addFirst(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */