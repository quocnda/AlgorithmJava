package Graph.Dijisktra;


import java.util.*;

 class Pair{
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
public class DuongDiNganNhatDenCacDinh {

    public static void Dijkstra(int n,List<List<Pair>> listedge,int start) {
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
            if(kcach > d[dinh]) {
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
            System.out.println(d[i]);
        }
    }
    public static void main(String[] args) {
        List<List<Pair>> listedgeke = new ArrayList<>();
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
            int y = scan.nextInt();
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
        int start = scan.nextInt();
        Dijkstra(V,listedgeke,start);
    }
}
