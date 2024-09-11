package hashmap.hashmap_implement;

/*
 * Build a simple map follow to Map (Collections Framework - Java)
 */
import java.util.Set;

public interface SimpleMapInterface<K, V> {
    // put with key and value
    Boolean put(K key, V value);

    // put entry
    Boolean putEntry(Entry<K, V> entry);

    // put a map into a map
    Boolean putAll(SimpleMapInterface<K, V> map);

    // remove a item from the map
    Boolean remove(K key, V value);

    // remove a submap from the map
    Boolean removeAll(SimpleMapInterface<K, V> map);

    // return size of the map
    Integer size();

    // check map is empty
    Boolean isEmpty();

    // return set of entry
    Set<Entry<K, V>> entrySet();

    // return set of key
    Set<K> keySet();
}
