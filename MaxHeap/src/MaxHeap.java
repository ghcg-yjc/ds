public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(data.getSize()-1); i >= 0 ; i--) {
            siftDown(i);
        }
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return getSize() == 0 ? true : false;
    }

    private int parent(int index) {
        if (index <= 0 || index >= getSize())
            throw new IllegalArgumentException("Index is not illegal,get parent failed");
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        int leftChild = index * 2 + 1;
        return leftChild;
    }

    private int rightChild(int index) {
        int rightChild = index * 2 + 2;
        return rightChild;
    }

    public void add(E e) {
        data.addLast(e);
        int index = getSize() - 1;
        siftUp(index);
    }

    public E findMax(){
        if (!isEmpty())
            return data.get(0);
        else {
            throw new IllegalArgumentException("MaxHeap is Empty.Can't find Max.");
        }
    }

    public E extractMax(){
        E max = findMax();
        E e = data.get(data.getSize()-1);
        data.removeLast();
        if (data.getSize() == 0)
            return max;
        data.set(0,e);
        siftDown(0);
        return max;
    }

    private void siftDown(int index) {
        int m = leftChild(index);
        if (m >= getSize())
            return;
        int n = rightChild(index);
        E e1 = data.get(m);
        E e2;
        if (n >= getSize())
            e2 = e1;
        else
            e2 = data.get(n);
        E now = data.get(index);
        if (e1.compareTo(now) > 0 || e2.compareTo(now) > 0){
            if (e1.compareTo(e2) >= 0){
                data.swap(m,index);
                siftDown(m);
            }else{
                data.swap(n,index);
                siftDown(n);
            }
        }
    }

    private void siftUp(int index) {
        if (index == 0)
            return;
        int parentIndex = parent(index);
        if (data.get(index).compareTo(data.get(parentIndex)) <= 0) {
            return;
        }
        E e = data.get(index);
        E parentE = data.get(parentIndex);
        data.set(index, parentE);
        data.set(parentIndex, e);
        siftUp(parentIndex);
    }

    public E replace(E e){
        E ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }

}
