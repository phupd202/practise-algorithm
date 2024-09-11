package hashmap.hashmap_implement;

public class Entry<K, V> {
    private K key;
    private V value;

    // constructor
    public Entry() {}

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // getter and setter
    public K getKey() {
        return key;
    }
    public void setKey(K key) {
        this.key = key;
    }
    public V getValue() {
        return value;
    }
    public void setValue(V value) {
        this.value = value;
    }

    
}
