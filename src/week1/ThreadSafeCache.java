package week1;//Lab Exercise #5: Implement a Thread-Safe Cache using ConcurrentHashMap

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeCache<K, V> {
    private Map<K, V> cache;

    public ThreadSafeCache() {
        cache = new ConcurrentHashMap<>();
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public V get(K key) {
        return cache.get(key);
    }

    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }

    public void remove(K key) {
        cache.remove(key);
    }
}
