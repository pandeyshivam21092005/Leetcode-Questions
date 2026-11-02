class LFUCache {
    int capacity,minfreq;
    Map<Integer,Integer> valueMap=new HashMap<>();
    Map<Integer,Integer> freqMap=new HashMap<>();
    Map<Integer,Deque<Integer>> DequeMap=new HashMap<>();
    public LFUCache(int capacity) {
        this.capacity=capacity;
        minfreq=0;
    }
    
    public int get(int key) {
        if(!valueMap.containsKey(key)){
            return-1;
        }
        updateFreq(key);
        return valueMap.get(key);
    }
    
    public void put(int key, int value) {
        if(capacity==0) return;

         // Existing key
        if(valueMap.containsKey(key)){
            valueMap.put(key,value);
            updateFreq(key);
            return;
        }
         // Cache full
        if (valueMap.size() == capacity) {

            Deque<Integer> dq = DequeMap.get(minfreq);

            int evictKey = dq.removeLast();

            valueMap.remove(evictKey);
            freqMap.remove(evictKey);
        }
         // Insert new key
        valueMap.put(key, value);
        freqMap.put(key, 1);

        DequeMap.computeIfAbsent(1, k -> new LinkedList<>())
                .addFirst(key);

        minfreq = 1;
    }

    public void updateFreq(int key) {

        int freq = freqMap.get(key);

        Deque<Integer> dq = DequeMap.get(freq);

        dq.remove(key);

        if (dq.isEmpty()) {

            DequeMap.remove(freq);

            if (minfreq == freq) {
                minfreq++;
            }
        }

        int newFreq = freq + 1;

        freqMap.put(key, newFreq);

        DequeMap.computeIfAbsent(newFreq, k -> new LinkedList<>())
                .addFirst(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */