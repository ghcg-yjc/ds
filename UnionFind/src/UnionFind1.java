public class UnionFind1 implements UF {
    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    private int find(int i) {
        if (i < 0 || i >= id.length) {
            throw new IllegalArgumentException("Index is out of bound.");
        }
        return id[i];
    }

    @Override
    public void unionElements(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (pid == qid) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (find(i) == pid) {
                id[i] = qid;
            }
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int getSize() {
        return id.length;
    }
}
