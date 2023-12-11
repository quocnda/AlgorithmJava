package Graph;// A Java program to implement Disjoint Set Data
// Structure.
import java.io.*;
import java.util.*;

    class DisjointUnionSets {
        int[] rank, parent;
        int n;

        // Constructor
        public DisjointUnionSets(int n)
        {
            rank = new int[n];
            parent = new int[n];
            this.n = n;
            makeSet();
        }

        // Creates n sets with single item in each
        void makeSet()
        {
            for (int i = 0; i < n; i++) {
                // Initially, all elements are in
                // their own set.
                parent[i] = i;
            }
        }

        // Returns representative of x's set
        int find(int x)
        {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }
        void union(int x, int y)
        {
            int xRoot = find(x), yRoot = find(y);
            if (xRoot == yRoot)
                return;
            if (rank[xRoot] < rank[yRoot])
                parent[xRoot] = yRoot;
            else if (rank[yRoot] < rank[xRoot])
                parent[yRoot] = xRoot;

            else
            {
                parent[yRoot] = xRoot;
                rank[xRoot] = rank[xRoot] + 1;
            }
        }
    }

public class UnionFind {
    public static void main(String[] args)
    {
        // Let there be 5 persons with ids as
        // 0, 1, 2, 3 and 4
        int n = 3;
        DisjointUnionSets dus =
                new DisjointUnionSets(n);

        // 0 is a friend of 2
        dus.union(0, 1);

        // 4 is a friend of 2
        dus.union(2, 0);

        // 3 is a friend of 1
        dus.union(1, 2);

        // Check if 4 is a friend of 0
        if (dus.find(0) == dus.find(1))
            System.out.println("Yes");
        else
            System.out.println("No");

        // Check if 1 is a friend of 0
        if (dus.find(0) == dus.find(2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
