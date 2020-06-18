import java.util.ArrayList;
import java.util.HashMap;

public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {

    private class Node{
        public K key;
        public V val;
        public Node left;
        public Node right;

        public Node(K key,V val,Node left,Node right){
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public Node(K key, V val) {
            this(key,val,null,null);
        }

        public Node(){
            this(null,null,null,null);
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        this.root = null;
        this.size = 0;
    }

    private Node getNode(K key){
        if(isEmpty())
            return null;
        return getNode(key,root);
    }

    private Node getNode(K key,Node node){
        if (node == null)
            return null;
        if (node.key.compareTo(key) == 0){
            return node;
        }else if (node.key.compareTo(key) > 0){
            return getNode(key,node.left);
        }else {
            return getNode(key,node.right);
        }
    }

    @Override
    public void add(K key, V val) {
        if (getNode(key) != null){
            set(key,val);
            return;
        }
        root = add(key,val,root);
    }

    private Node add(K key, V val, Node node) {
        if (node == null){
            size++;
            return new Node(key,val);
        }
        if(key.compareTo(node.key) > 0){
            node.right = add(key,val,node.right);
        }else {
            node.left = add(key,val,node.left);
        }
        return node;
    }

    @Override
    public V remove(K key) {
        if(getNode(key) == null){
            return null;
        }
        return remove(root,key).val;
    }

    private Node remove(Node node, K key) {
        if (node.key.compareTo(key) == 0){
            if (node.left == null){
                Node nodeRight = node.right;
                node.right = null;
                size--;
                node = nodeRight;
            }else if (node.right == null){
                Node nodeLeft = node.left;
                node.left = null;
                size--;
                node = nodeLeft;
            }else {
                Node minNode = minimum(node.right);
                Node newNode = removeMin(node.right);
                node.right = newNode;
                node.key = minNode.key;
                node.val = minNode.val;
            }
            return node;
        }else if (node.key.compareTo(key) > 0){
            node.left = remove(node.left,key);
            return node;
        }else {
            node.right = remove(node.right,key);
            return node;
        }
    }

    private Node removeMin(Node node) {
        if(node.left == null){
            Node nodeRight = node.right;
            size--;
            return nodeRight;
        }
        node.left = removeMin(node.left);
        return node;
    }

    private Node minimum(Node node) {
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    @Override
    public V get(K key) {
        if (getNode(key) != null)
            return getNode(key).val;
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public void set(K key, V val) {
        Node node = getNode(key);
        node.val = val;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        BSTMap<String,Integer> map = new BSTMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        FileOperation.readFile("Map/pride-and-prejudice.txt",arrayList);
        System.out.println("Pride and Prejudice:");
        System.out.println("Total words:"+arrayList.size());
        for (String word:arrayList) {
            if (!map.contains(word)){
                map.add(word,1);
            }else {
                map.set(word,map.get(word)+1);
            }
            if (map.get("argument") != null && map.get("argument") == 3){
//            if ( 3 == map.get("argument")){
                map.remove("argument");
            }
        }
        System.out.println("Total different words:"+map.getSize());
        System.out.println("pride:"+map.get("pride"));
        System.out.println("prejudice:"+map.get("prejudice"));
        System.out.println("argument:"+map.get("argument"));
        System.out.println("asdffffffggg:"+map.get("asdffffffggg"));
    }

}
