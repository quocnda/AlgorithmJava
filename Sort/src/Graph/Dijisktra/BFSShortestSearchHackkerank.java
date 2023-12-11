package Graph.Dijisktra;

import java.util.*;

public class BFSShortestSearchHackkerank {
    public static void BFSShorterst(int n,List<List<Pair>> listedge,int start) {
        int[] d =new int[n];
        for(int i = 0 ; i < n; i ++) {
            d[i] = Integer.MAX_VALUE;
        }
        d[start] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.getY() - o2.getY();
            }
        });
        pq.add(new Pair(start,0));
        while(!pq.isEmpty()) {
            Pair t = pq.poll();
            int dinh = t.getX();
            int kcach = t.getY();
            if(kcach != d[dinh]) {
                continue;
            }
            for(int i = 0 ; i < listedge.get(dinh).size(); i++) {
                Pair temp = listedge.get(dinh).get(i);
                int v = temp.getX();
                int dv = temp.getY();
                if(d[v] > kcach + dv) {
                    d[v] = kcach + dv ;
                    pq.add(new Pair(v,d[v]));
                }
            }
        }
        for(int i= 0 ; i < n; i++) {
            if(d[i] == 0) {
                continue;
            }
            if(d[i] == Integer.MAX_VALUE) {
                System.out.print(-1+" ");
                continue;
            }
            System.out.print(d[i]+" ");
        }
    }
    public static void main(String[] args) {
        List<List<Pair>> listedgeke = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while(q>0) {
            int V = scan.nextInt();
            for(int  i = 0 ; i < V; i ++) {
                List<Pair> tmp = new ArrayList<>();
                listedgeke.add(tmp);
            }
            int scanh = scan.nextInt();
            for(int i = 0 ; i < scanh ; i++) {
                int x = scan.nextInt();
                int y = scan.nextInt();
                Pair t = new Pair(y,6);
                Pair tmp = new Pair(x,6);
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
            int start = scan.nextInt();
            BFSShorterst(V,listedgeke,start);
            q--;
        }

    }
}
