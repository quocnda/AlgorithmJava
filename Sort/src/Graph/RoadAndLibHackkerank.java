package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoadAndLibHackkerank {
    public static int buildRoad(int u, List<List<Integer>> A,boolean[] Free){
        int nRoad = 0;
        List<Integer> t = A.get(u);
        for(int i = 0 ; i < t.size() ; i ++) {
            int v = t.get(i);
            if(Free[v]) {
                Free[v] = false;
                nRoad+=buildRoad(v,A,Free)+1;
            }
        }
        return nRoad;
    }
    public static long roadAndLibraries(int n,int c_lib,int c_road,List<List<Integer>> cities) {
        boolean[] Free = new boolean[n];
        for(int  i = 0 ; i < n; i ++) {
            Free[i] = true;
        }
        List<List<Integer>> A = new ArrayList<>();
        for(int i  = 0 ; i < n; i ++) {
            List<Integer> tmp = new ArrayList<>();
            A.add(tmp);
        }
        for(int i = 0 ; i < cities.size() ; i++) {
            int  u = cities.get(i).get(0);
            int v = cities.get(i).get(1);
            A.get(u).add(v);
            A.get(v).add(u);
        }
//        1
        long minium = 0;
        for(int i = 0 ; i < n ; i++) {
            if(Free[i]) {
                Free[i] = false;
                minium+=c_lib;
                minium+=buildRoad(i,A,Free)*Math.min(c_road,c_lib);
            }
        }
        return minium;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while(q > 0) {
            List<List<Integer>> A = new ArrayList<>();
            int n  =scan.nextInt();
            int m = scan.nextInt();
            int lib = scan.nextInt();
            int road = scan.nextInt();
            for(int  i = 0 ; i < m; i ++) {
                List<Integer> tmp = new ArrayList<>();
                int x = scan.nextInt();
                int y = scan.nextInt();
                x--;
                y--;
                tmp.add(x);
                tmp.add(y);
                A.add(tmp);
            }
            long ans = roadAndLibraries(n,lib,road,A);
            System.out.println(ans);
        }
    }
}
