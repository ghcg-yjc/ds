import java.util.Arrays;

public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private Merge<E> merge;

    public SegmentTree(E[] arr, Merge<E> merge) {
        this.merge = merge;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        buildSegmengTree(0, 0, data.length - 1);
    }

    private void buildSegmengTree(int index, int l, int r) {
        if (data[l] == data[r]) {
            tree[index] = data[l];
            return;
        }
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);
        /*
        l,mid
        mid+1 r
         */
        int mid = l + (r - l) / 2;
        buildSegmengTree(leftIndex, l, mid);
        buildSegmengTree(rightIndex, mid + 1, r);
        tree[index] = merge.merge(tree[leftIndex], tree[rightIndex]);
    }

    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("索引异常，查询失败");
        }

        return query(0, 0, data.length - 1, queryL, queryR);
    }

    private E query(int index, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[index];
        }
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);
        int mid = l + (r - l) / 2;
        if (queryL >= mid + 1) {
            return query(rightIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            return query(leftIndex, l, mid, queryL, queryR);
        }

        E e1 = query(leftIndex, l, mid, queryL, mid);
        E e2 = query(rightIndex, mid + 1, r, mid + 1, queryR);
        return merge.merge(e1, e2);
    }

    public int getSize() {
        return tree.length;
    }

    public E get(int index) {
        if (index < 0 || index > getSize()) {
            throw new IllegalArgumentException("索引异常，获取失败！");
        }

        return tree[index];
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        return "SegmentTree{" + Arrays.toString(tree) +
                '}';
    }
}
