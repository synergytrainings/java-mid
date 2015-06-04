package pavel.midtraining.collections;

import java.util.*;

/**
 * This is a simple implementation of cache using WeakHashmap
 */
public class Cache<K,V> extends AbstractMap<K,V> {
    /**
     * The initial capacity of cache
     */
    private static final int INITIAL_CAPACITY = 5;
    /**
     * The internal map that will hold the weakly-referenced data
     */
    private final Map<K,V> map = new WeakHashMap<K,V>();
    /**
     * The capacity of cache
     */
    private final int capacity;
    /**
     * This list is used to keep strong references to last used keys
     */
    private final List<K> hardCache = new LinkedList<K>();


    public Cache() {
        this(INITIAL_CAPACITY);
    }

    public Cache(int capacity) {
        this.capacity = capacity;
    }

    public Cache(Map<? extends K, ? extends V> mapToPut) {
        this();
        this.map.putAll(mapToPut);
    }

    public V get(Object key) {
        V val = map.get(key);
        if (val != null) {
           hardCache.add((K) key);
           if (hardCache.size() > capacity){
               removeAtLeastUsedKey();
           }
        }
        return val;
    }

    public V put(K key, V value) {
        if (value != null) {
           hardCache.add((K) key);
           if (hardCache.size() > capacity){
               removeAtLeastUsedKey();
           }
        }
        return map.put(key, value);
    }

    public V remove(Object key) {
        if(key != null){
            Iterator<K> iter = hardCache.iterator();
            while(iter.hasNext()){
                if(iter.next().equals(key)){
                    iter.remove();
                }
            }
        }
        return map.remove(key);
    }

    public void clear() {
        hardCache.clear();
        map.clear();
    }

    /**
     * Removes at least used (first) key from hard cache
     */
    private void removeAtLeastUsedKey(){
        Iterator<K> iter = hardCache.iterator();
        iter.next();
        iter.remove();
    }

    public int size() {
        return map.size();
    }

    public Set<Entry<K,V>> entrySet() {
        return map.entrySet();
    }
}
