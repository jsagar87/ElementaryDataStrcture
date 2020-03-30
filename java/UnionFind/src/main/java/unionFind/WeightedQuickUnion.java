package unionFind;

public class WeightedQuickUnion implements UnionFind{

    private int n;
    private int count;
    private int id[];
    private int sz[];

    public WeightedQuickUnion(int n) {
        this.count = 0;
        this.n = n;
        id = new int[n];
        sz = new int[n];

        for (int i = 0 ; i < n; i++ ) {
            id[i] = i;
            sz[i] = 1;
        }
    }


    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if (i==j) return;

        if   (sz[i]<sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else               { id[j] = i; sz[i] += sz[j]; }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        validate(p);
        while (p!=id[p]) {
            p = id[p];
        }
        return p;
    }

    public int count() {
        return count;
    }

    private void validate(int p){
        if (p<0 || p>=n)
            throw new IllegalStateException("index p is not between 0 and " + (n-1));
    }
}
