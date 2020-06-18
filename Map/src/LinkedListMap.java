public class LinkedListMap<K,V> implements Map<K,V> {

    private class Node{
        public K key;
        public V val;
        public Node next;

        public Node(K key,V val,Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }

        public Node(K key){
            this(key,null,null);
        }

        public Node(){
            this(null,null,null);
        }

    }

    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        this.dummyHead = new Node();
        this.size = 0;
    }

    @Override
    public void add(K key, V val) {
        if(contains(key)){
            set(key,val);
        }else {
            dummyHead.next = new Node(key, val,dummyHead.next);
            size++;
        }
    }

    @Override
    public V remove(K key) {

        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.key.equals(key)){
                Node delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
                size--;
                return delNode.val;
            }
            prev = prev.next;
        }
        return null;
    }

    @Override
    public V get(K key) {
        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.key.equals(key)){
                return prev.next.val;
            }
            prev = prev.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.key.equals(key)){
                return true;
            }
            prev = prev.next;
        }
        return false;
    }

    @Override
    public void set(K key, V val) {
        Node prev = dummyHead;
        while(prev.next != null){
            if (prev.next.key == null){
                System.out.println("---------------------------------------------");
            }
            if(prev.next.key.equals(key)){
                prev.next.val = val;
                return;
            }
            prev = prev.next;
        }
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public int getSize() {
        return size;
    }
}
