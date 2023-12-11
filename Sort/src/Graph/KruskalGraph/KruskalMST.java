package Graph.KruskalGraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class KruskalMST {
    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Subset {
        int parent, rank;

        public Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    public static void kruskals(int v, List<Edge> edges) {
        int j = 0;
        int noOfEdges = 0;
        Subset subsets[] = new Subset[v];
        Edge results[] = new Edge[v];
        for (int i = 0; i < v; i++) {
            subsets[i] = new Subset(i, 0);
        }
        while (noOfEdges < v - 1) {
            Edge nextEdges = edges.get(j);
            int x = findRoot(subsets, nextEdges.src);
            int y = findRoot(subsets, nextEdges.dest);
            if (x != y) {
                results[noOfEdges] = nextEdges;
                union(subsets, x, y);
                noOfEdges++;
            }
            j++;
        }

        System.out.println(
                "Following are the edges of the constructed MST:");
        int minCost = 0;
        for (int i = 0; i < noOfEdges; i++) {
            System.out.println(results[i].src + " -- "
                    + results[i].dest + " == "
                    + results[i].weight);
            minCost += results[i].weight;
        }
        System.out.println("Total cost of MST: " + minCost);
    }

    public static int findRoot(Subset[] subsets, int i) {
        if (subsets[i].parent == i) {
            return subsets[i].parent;
        }
        subsets[i].parent = findRoot(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    public static void union(Subset[] subsets, int x, int y) {
        int rootX = findRoot(subsets, x);
        int rootY = findRoot(subsets, y);
        if (subsets[rootY].rank < subsets[rootX].rank) {
            subsets[rootY].parent = rootX;
        } else if (subsets[rootX].rank < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        } else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    public static void main(String[] args) {

        List<Edge> graphEdges = new ArrayList<Edge>();
        Scanner scan = new Scanner(System.in);
        System.out.println("nhap so dinh");
        int V = scan.nextInt();
        System.out.println("nhap so hang danh sach ke dua do thi");
        int hang = scan.nextInt();
        for(int  i = 0 ; i < hang; i++) {
            int src = scan.nextInt();
            int dest  = scan.nextInt();
            int weight = scan.nextInt();
            Edge t  =new Edge(src,dest,weight);
            graphEdges.add(t);
        }
        graphEdges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        kruskals(V, graphEdges);

    }

}