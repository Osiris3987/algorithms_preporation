package kontur;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int combinations = scan.nextInt();
        Pair[] rowColorIteration = new Pair[n];
        int[][] arr = new int[n][m];
        Pair[] colColorIteration = new Pair[m];
        Arrays.fill(rowColorIteration, new Pair(0, -1));
        Arrays.fill(colColorIteration, new Pair(0, -1));

        for(int i = 0; i < combinations; i++){
            int row = scan.nextInt()-1;
            int col = scan.nextInt()-1;
            int color = scan.nextInt();
            rowColorIteration[row] = new Pair(color, i);
            colColorIteration[col] = new Pair(color, i);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(rowColorIteration[i].iteration >= colColorIteration[j].iteration) {
                    System.out.print(rowColorIteration[i].color + " ");
                } else {
                    System.out.print(colColorIteration[j].color + " ");
                }
            }
            System.out.println();
        }

    }
    private static class Pair{
        int color;
        int iteration;
        Pair(int x, int y){
            this.color = x;
            this.iteration = y;
        }
    }
}
