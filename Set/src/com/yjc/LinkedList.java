package com.yjc;

public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        dummyHead.next = new Node(e, dummyHead.next);
        size++;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("添加失败，索引错误。。。");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    public E get(int index) {
        Node node = dummyHead;
        for (int i = 0; i <= index; i++) {
            node = node.next;
        }
        return node.e;
    }

    public void modify(int index,E e){
        Node node = dummyHead;
        for (int i = 0; i <= index; i++) {
            node = node.next;
        }
        node.e = e;
    }

    public E remove(int index){
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = prev.next;
        prev.next = node.next;
        size--;
        return node.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    public void removeElement(E e){
        Node prev = dummyHead;
        while(prev.next != null){
            if (prev.next.e == e)
                break;
            prev = prev.next;
        }
        if (prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    // 查找链表中是否有元素e
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LinkedList:size=%d.head->{", size));
        Node node = dummyHead;
        for (int i = 0; i < size; i++) {
            node = node.next;
            res.append(node);
            if (i != size - 1)
                res.append("->");
        }
        res.append("}");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i, i);
        }
        System.out.println(linkedList);

        linkedList.add(3, 14);
        System.out.println(linkedList);
        linkedList.addFirst(15);
        System.out.println(linkedList);

        System.out.println(linkedList.get(3));
        linkedList.modify(3,33);
        System.out.println(linkedList);

        linkedList.remove(4);
        System.out.println(linkedList);
    }

}
