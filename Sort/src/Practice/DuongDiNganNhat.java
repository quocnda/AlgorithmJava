package Practice;

import java.util.*;

class Pair{
    public int x;
    public int y;
    Pair(int x,int y) {
        this.x = x;
        this.y = y;
    }

}
public class DuongDiNganNhat {
    public static void Dijsktra(List<List<Pair>> listedges,int start,int numdinh) {
        int[] d =new int[numdinh];
        for(int  i = 0 ; i < numdinh; i ++) {
            d[i] = Integer.MAX_VALUE;
        }
        d[start] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.y - o2.y;
            }
        });
        pq.add(new Pair(start, 0 ));
        while(!pq.isEmpty()) {
            Pair temp  = pq.poll();
            int dinh = temp.x;
            int kcach = temp.y;
            if(kcach > d[dinh]) {
                continue;
            }
            for(int  i = 0 ; i < listedges.get(dinh).size(); i ++) {
                Pair tmp = listedges.get(dinh).get(i);
                int v = tmp.x;
                int dv = tmp.y;
                if(d[v] > dv + kcach) {
                    d[v] = dv + kcach;
                    pq.add(new Pair(v,d[v]));
                }
            }
        }
        for(int i= 0 ; i < numdinh; i++) {
            System.out.println(d[i]);
        }

    }
    public static void main(String[] args) {
        Scanner scan  =new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        List<List<Pair>> listedges = new ArrayList<>();
        for(int  i = 0 ; i < n; i ++) {
            List<Pair> tmp = new ArrayList<>();
            listedges.add(tmp);
        }
        while (m>0) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int weight = scan.nextInt();
            Pair x1 = new Pair(x,weight);
            Pair y1 = new Pair(y,weight);
            listedges.get(x).add(y1);
            listedges.get(y).add(x1);
            m--;
        }
        for(int  i = 0 ; i < listedges.size() ; i ++) {
            System.out.print(i+" ");
            List<Pair> lis = listedges.get(i);
            for(int  j = 0 ; j < lis.size() ; j ++) {
                System.out.print(lis.get(j).x+" ");
                System.out.print(lis.get(j).y+" ");
            }
            System.out.println("");
        }
        Dijsktra(listedges,0,n);
    }
}
