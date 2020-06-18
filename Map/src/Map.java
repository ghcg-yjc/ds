public interface Map<K,V> {
    void add(K key,V val);
    V remove(K key);
    V get(K key);
    boolean contains(K key);
    void set(K key,V val);
    boolean isEmpty();
    int getSize();
}
