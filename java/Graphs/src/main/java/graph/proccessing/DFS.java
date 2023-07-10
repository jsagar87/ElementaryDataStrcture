package graph.proccessing;

import edu.princeton.cs.algs4.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Reachability
 * Problem:   Find all vertices reachable from s, along a directed path.
 */
public class DFS {
    boolean marked[];
    int edgeTo[];
    // Variable S represents Source for which computation is done
    int S = 0;

    public DFS(int V, int S, Graph G) {
        for (int x=0;x<V;x++) {
            this.marked[x] = false;
            this.edgeTo[x] = -1;
        }

    }
//    public DFS(int V, int S, Graph G) {
//        for (int x=0;x<V;x++) {
//            this.marked[x] = false;
//            this.edgeTo[x] = -1;
//        }
//        Queue<Integer> processQueue = new LinkedList<Integer>();
//        processQueue.add(S);
//        this.edgeTo[S] = S;
//        while (!processQueue.isEmpty()) {
//            Integer elemId =  processQueue.remove();
//            if (!this.marked[elemId]) {
//                this.marked[elemId] = true;
//                for (int e : G.adj(elemId)) {
//                    processQueue.add(e);
//                    this.edgeTo[e] = elemId;
//                }
//            }
//        }
//    }


}
