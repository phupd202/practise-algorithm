package hashmap.hashmap_implement;

import java.util.Set;

/*
 * Implement a simple hashmp
 * Using 2 same size array
 */
public class SimpleHashMap<K, V extends Comparable<V>> implements SimpleMapInterface<K, V>{
    private K[] keys;
    private V[] values;
    private int n = 0; // count item already existed in the map
    private int defaultSize;

    // constructor
    public SimpleHashMap() {
        this.keys = (K[]) new Object[defaultSize];
        this.values = (V[]) new Object[defaultSize];
    }

    // constructor
    public K[] getKeys() {
        return keys;
    }

    public void setKeys(K[] keys) {
        this.keys = keys;
    }

    public V[] getValues() {
        return values;
    }

    public void setValues(V[] values) {
        this.values = values;
    }

    @Override
    /*
     * Complexity of operation build map: O(n^2) - because using 2 loop
     * Decrease complexity: Using 2 sorted array --> 
     * 
     */
    public Boolean put(K key, V value) {
        // if empty --> dont need check existed
        if(this.isEmpty()) {
            keys[n] = key;
            values[n] = value;
            n++;
            return true;
        } else {
            // check existed
            for (int i = 0; i < this.size(); i++) {
                if(keys[i].equals(key)) {
                    return false;
                }
            }

            // if not existed --> insert
            if(this.size() >= defaultSize) {
                // scale array if overflow
                K[] newKeys = (K[]) new Object[defaultSize * 2];
                V[] newValues = (V[]) new Object[defaultSize * 2];

                // copy old item into new array
                System.arraycopy(keys, 0, newKeys, 0, defaultSize);
                System.arraycopy(values, 0, newValues, 0, defaultSize);
                this.keys = newKeys;
                this.values = newValues;
            }

            // Remain a sorted array
            if(value.compareTo(values[n - 1]) >= 0) {
                keys[n] = key;
                values[n] = value;
                n++;
            } else {
                int posInsert = -1;
                for (int i = n - 1; i >= 0; i--) {
                    if(value.compareTo(values[i]) >= 0) {
                        posInsert = i;
                    }
                }

                // move array
                for (int i = n; i >= posInsert + 1; i--) {
                    values[i] = values[i - 1];
                    keys[i] = keys[i - 1];
                }
                keys[posInsert] = key;
                values[posInsert] = value;
                n++;
            }
            return true;
        }
    }

    @Override
    public Boolean putEntry(Entry<K, V> entry) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putEntry'");
    }

    @Override
    public Boolean putAll(SimpleMapInterface<K, V> map) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putAll'");
    }

    @Override
    public Boolean remove(K key, V value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public Boolean removeAll(SimpleMapInterface<K, V> map) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
    }

    @Override
    public Integer size() {
        return n;
    }

    @Override
    public Boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'entrySet'");
    }

    @Override
    public Set<K> keySet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keySet'");
    } 
}
