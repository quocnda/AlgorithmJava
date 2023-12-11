package Practice;

import java.util.*;

class Edges {
    int x;
    int y;
    int weight;
    Edges(int x,int y,int w) {
        this.x = x;
        this.y = y;
        this.weight = w;
    }
}
class UnionFind{
    int n;
    int[] parent;
    int[] size;
    UnionFind(int n) {
        this.n = n;
        parent = new int[n];
        size = new int[n];
        ktao();
    }
    public void ktao() {
        for(int i = 0 ; i < n; i ++) {
            parent[i] = i;
        }
        for(int i = 0; i < n; i ++) {
            size[i] = 1;
        }
    }
    public int findpar(int a) {
        if(parent[a] == a) {
            return a;
        }
        return parent[a] = findpar(parent[a]);
    }
    public void Union(int a,int b) {
        int pa = findpar(a);
        int pb = findpar(b);
        if(pa != pb) {
            if(size[pa] > size[pb]) {
                int tmp = pa;
                pa = pb;
                pb = tmp;
            }
            parent[pa] = pb;
            size[pb]+=size[pa];
        }
    }
}
public class CayKhungNhoNhat {
    public static void Kruskal(List<Edges> listedges,int sodinh) {
        int ansmin = 0;
        UnionFind un = new UnionFind(sodinh);
        List<Edges> ans = new ArrayList<>();
        PriorityQueue<Edges> pq = new PriorityQueue<>(new Comparator<Edges>() {
            @Override
            public int compare(Edges o1, Edges o2) {
                return o1.weight - o2.weight;
            }
        });
        for(int i = 0 ; i < listedges.size() ; i ++) {
            pq.add(listedges.get(i));
        }
        for(int i = 1 ; i < sodinh ; i ++) {
            Edges min = pq.poll();
            while (!pq.isEmpty() && (un.findpar(min.x) == un.findpar(min.y))) {
                min = pq.poll();
            }
            un.Union(min.x,min.y);
            ansmin+=min.weight;
            ans.add(min);
        }
        for(int  i = 0 ; i < ans.size(); i ++) {
            System.out.print(ans.get(i).x+" "+ans.get(i).y+" "+ans.get(i).weight);
            System.out.println("");
        }
        System.out.println(ansmin);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sodinh = scan.nextInt();
        int socanh = scan.nextInt();
        List<Edges> listedges = new ArrayList<>();
        while(socanh > 0) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int w = scan.nextInt();
            x--;
            y--;
            listedges.add(new Edges(x,y,w));
            socanh --;
        }
        Kruskal(listedges,sodinh);

    }
}
