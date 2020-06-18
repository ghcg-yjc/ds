package com.yjc;

public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
        add(size,e);
    }

    public void add(int index, E e) {

        if(size == data.length){
            resize(2*data.length);
        }

        if (index < 0 || index > size)
            throw new IllegalArgumentException("添加失败，索引异常。。。");

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newdata = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newdata[i] = data[i];
        }
        data = newdata;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size=%d,capacity=%d\n",size,data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size-1)
                res.append(",");
        }
        res.append("]");
        return res.toString();
    }

    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("索引异常。。。");
        return data[index];
    }

    public void set(int index,E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("索引异常。。。");
        data[index] = e;
    }

    public boolean cotains(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    public int find(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    public E remove(int index){
        E ret = data[index];
        for (int i = index; i < size-1; i++) {
            data[i] = data[i+1];
        }
        size--;
        data[size] = null;
        if (size < data.length/2){
            resize(data.length/2);
        }
        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    public void removeElement(E e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    public static void main(String[] args) {
        Array<Integer> array = new Array<>(10);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }

        System.out.println(array);

        array.add(1,100);
        System.out.println(array);

        array.addFirst(-1);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);

        array.removeElement(4);
        System.out.println(array);

        array.removeElement(9);
        System.out.println(array);
    }
}
