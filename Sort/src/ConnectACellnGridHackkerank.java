import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class ConnectACellnGridHackkerank {
    public static int connectedCell(List<List<Integer>> matrix) {
        int max = 0;
        for (int i=0; i< matrix.size();i++) {
                for (int j=0; j< matrix.get(i).size();j++) {
                        if(matrix.get(i).get(j) == 1) {
                                int curMax = recurCountConnected(i, j, matrix);
                                max = Math.max(curMax, max);
                        }
                }
        }
        return max;
}

private static int recurCountConnected(int i, int j, List<List<Integer>> matrix) {
if (i < 0 || j < 0 || i >= matrix.size() || j >= matrix.get(i).size() || matrix.get(i).get(j)==0) {
return 0;
}
int count = 0;
if (matrix.get(i).get(j)==1) {
count = 1;
matrix.get(i).set(j, 0);
count += recurCountConnected(i-1, j-1, matrix);
count += recurCountConnected(i-1, j, matrix);
count += recurCountConnected(i-1, j+1, matrix);
count += recurCountConnected(i, j-1, matrix);
count += recurCountConnected(i, j, matrix);
count += recurCountConnected(i, j+1, matrix);
count += recurCountConnected(i+1, j-1, matrix);
count += recurCountConnected(i+1, j, matrix);
count += recurCountConnected(i+1, j+1, matrix);
}
return count;

}
    public static void main(String[] args) {
        int n;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        List<List<Integer>> matrix = new ArrayList<>();
        for(int  i = 0 ; i < n;i++) {
            List<Integer> lis = new ArrayList<Integer>();
            for(int j = 0 ; j < n; j ++) {
                int t = scan.nextInt();
                lis.add(t);  
            }
            matrix.add(lis);
        }
        System.out.println(connectedCell(matrix));
    }
}
