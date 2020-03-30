package unionFind;

public class QuickUnion implements UnionFind{

    private int n;
    private int count;
    private int id[];

    public QuickUnion(int n) {
        this.n = n;
        this.count = 0;
        id = new int[n];
        for (int i = 0 ; i < n; i++ ) {
            id[i] = i;
        }
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i==j) return ;
        id[i] = j;
        this.count++;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int i) {
        int idx = i;
        while (id[idx]!=i) {
            idx = i ;
        }
        return idx;
    }

    public int count() {
        return count;
    }

    private void validate(int p){
        if (p<0 || p>=n)
            throw new IllegalStateException("index p is not between 0 and " + (n-1));
    }
}
