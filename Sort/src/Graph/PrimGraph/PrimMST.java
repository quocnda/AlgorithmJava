package Graph.PrimGraph;

import java.util.*;

public class PrimMST {
    public static List<List<Pair>> listedgeke = new ArrayList<>();
    static class canh{
        int src,dest,w;
        canh(int src,int dest,int w) {
            this.src = src;
            this.dest = dest;
            this.w = w;
        }
    }
    static class Pair{
        int x;
        int y;
        Pair(int x,int y) {
            this.x = x;
            this.y = y;
        }
        public  int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }
    public static void Prim(boolean[] vis,List<List<Pair>> listedgeke,int start) {
        List<canh> MST = new ArrayList<>();
        int s = 0;
        vis[start] = true;
        int n = vis.length;
        while(MST.size() < n-1) {
            int min_V = Integer.MAX_VALUE;
            int x=0;
            int y=0;
            for(int i = 0; i < n;i++) {
                if(vis[i]) {
                    for(Pair p : listedgeke.get(i)) {
                        int j = p.getX();
                        int trongso = p.getY();
                        if(!vis[j] && trongso < min_V) {
                            min_V = trongso;
                            x = j;
                            y = i;
                        }
                    }
                }
            }
            MST.add(new canh(x,y,min_V));
            s+=min_V;
            vis[x] = true;
        }
        for(canh c : MST) {
            System.out.println(c.src+" "+ c.dest+" "+c.w);
        }
        System.out.println(s);
    }
    public static void PrimUsingQueue(boolean[] vis, List<List<Pair>> listedgeke, int start) {
        Queue<Pair> q = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.getY() - o2.getY();
            }
        });
        List<canh> MST = new ArrayList<>();
        int res = 0;
        q.add(new Pair(start, 0));

        while (!q.isEmpty()) {
            Pair t = q.poll();
            int dinh = t.getX();
            int trongso = t.getY();

            if (vis[dinh]) {
                continue;
            }

            res += trongso;
            vis[dinh] = true;
            for (Pair p : listedgeke.get(dinh)) {
                if (!vis[p.getX()]) {
                    q.add(p);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("nhap so dinh");
        Scanner scan = new Scanner(System.in);
        int V = scan.nextInt();
        for(int  i = 0 ; i < V; i ++) {
            List<Pair> tmp = new ArrayList<>();
            listedgeke.add(tmp);
        }
        System.out.println("nhap so canh");
        int scanh = scan.nextInt();
        for(int i = 0 ; i < scanh ; i++) {
            int x = scan.nextInt();
            x--;
            int y = scan.nextInt();
            y--;
            int w = scan.nextInt();
            Pair t = new Pair(y,w);
            Pair tmp = new Pair(x,w);
            listedgeke.get(x).add(t);
            listedgeke.get(y).add(tmp);
        }
        for(int  i = 0 ; i < V ; i++) {
            List<Pair> tmp  = listedgeke.get(i);
            System.out.print(i+" ");
            for(Pair p : tmp) {
                System.out.print(p.getX() +" "+p.getY()+" ");
            }
            System.out.println("");
        }
        boolean[] vis = new boolean[V];
        for(int i = 0 ; i < vis.length ;i ++) {
            vis[i] =false;
        }
        int start = scan.nextInt();
        Prim(vis,listedgeke,start);
    }
}
