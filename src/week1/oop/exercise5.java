package week1.oop;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class exercise5<K, V> {
    // Utilizing ConcurrentHashMap for thread-safe operations
    private Map<K, V> cache;

    public exercise5() {
        cache = new ConcurrentHashMap<>();
    }

    // Adds or updates a key-value pair in the cache
    public void put(K key, V value) {
        cache.put(key, value);
    }

    // Retrieves the value for a given key from the cache
    public V get(K key) {
        return cache.get(key);
    }

    // Checks if a key exists in the cache
    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }

    // Removes a key-value pair from the cache
    public void remove(K key) {
        cache.remove(key);
    }
}