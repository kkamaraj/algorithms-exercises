package com.samples;

import java.util.*;

/**
 * Created by kkama4 on 9/12/16.
 */
public class GraphSearch {
    public static int TYPE_BFS = 1;
    public static int TYPE_DFS = 2;

    List<Integer> adj[];
    int searchType = 0;

    public GraphSearch(int searchType) {
        this.searchType = searchType;
    }

    public void buildGraph(Scanner in) {
        int v = in.nextInt();
        adj = (ArrayList<Integer>[]) new ArrayList[v];
        int e = in.nextInt();
        for (int i = 0; i < e; i++) {
            int e1 = in.nextInt();
            int e2 = in.nextInt();
            adj[e1].add(e2);
            adj[e2].add(e1);
        }
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
