package structClass.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU<K,V> extends LinkedHashMap<K,V> implements Map<K,V> {

    public LRU(int initialCapacity,float loadFactor,boolean accessOrder){
        super(initialCapacity,loadFactor,accessOrder);
    }


    @Override
    public boolean removeEldestEntry(java.util.Map.Entry<K,V> eldest){
        if(size() > 6){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LRU<Character, Integer> lru = new LRU<Character, Integer>(
                16, 0.75f, true);

        String s = "abcdefghijkl";
        for (int i = 0; i < s.length(); i++) {
            lru.put(s.charAt(i), i);
        }
        System.out.println("LRU中key为h的Entry的值为： " + lru.get('h'));
        System.out.println("LRU的大小 ：" + lru.size());
        System.out.println("LRU ：" + lru);
    }
}
