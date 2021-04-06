package structClass.util;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private LinkedHashMap<Integer,Integer> map;

    private int capacity;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return map.size() > capacity;
            }
        };
    }

    public int get(int key) {
//        BigInteger integer = new BigInteger();
        if(map.containsKey(key)){
            int value = map.get(key);
            map.remove(key);
            map.put(key,value);
            return value;
        }
        return -1;
//       return map.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
        }
        while (map.size()>=capacity){
            map.remove(map.entrySet().iterator().next().getKey());
        }
        map.put(key,value);
    }
}
