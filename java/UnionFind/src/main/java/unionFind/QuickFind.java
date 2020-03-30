package unionFind;

public class QuickFind implements UnionFind {

    private int n;
    private int count;
    private int id[];

    /**
     *  Initialize union-find data structure with
     *   n objects (0 to n – 1)
     * @param n
     */
    public QuickFind(int n) {
        this.n = n;
        this.count = 0;
        id = new int[n];
        for (int i = 0 ; i < n; i++ ) {
            id[i] = i;
        }
    }

    public void union(int p, int q) {
        int idp = id[p];
        int idq = id[q];
        boolean change = false;
        for (int i = 0; i< n; i++) {
            if( id[i] == idp ) {
                id[i] = idq;
                change = true;
            }
        }
        if(change) this.count++;
    }

    public boolean connected(int p, int q) {
        return id[p]==id[q];
    }

    public int find(int p) {
        validate(p);
        while (p!=id[p]) {
            p = id[p];
        }
        return p;
    }

    public int count() {
        return this.count;
    }

    private void validate(int p){
        if (p<0 || p>=this.n)
            throw new IllegalStateException("index p is not between 0 and " + (n-1));
    }
}
