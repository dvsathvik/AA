package AA;
import java.util.Scanner;

public class Assignment{

    static int n;
    static int[][] cost;
    static boolean[] isUsed;
    static int minCost = Integer.MAX_VALUE;
    static int[] bestAssign;
    static int[] currentAssign; 
    static int curCost = 0;

    public static void pri(String a){
        System.out.print(a);
    }
    public static void prin(String a){
        System.out.println(a);
    }


    private static void solve(int cur_worker){
        if (cur_worker == n){
            if (curCost < minCost){
                minCost = curCost;
                bestAssign = currentAssign.clone();
            }
            return;
        }

        for (int i = 0; i < n ; i++){
            if (!isUsed[i]){
                isUsed[i] = true;
                currentAssign[cur_worker] = i;
                curCost += cost[cur_worker][i];
                solve(cur_worker+1);
                curCost -= cost[cur_worker][i];
                currentAssign[cur_worker] = -1;
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        pri("Enter number of workers : ");
        n = sc.nextInt();
        cost = new int[n][n];
        isUsed = new boolean[n];
        currentAssign = new int[n];
        pri("Enter cost matrix " + n + " X "+ n + " : ");
        for (int i = 0;  i < n ; i ++){
            isUsed[i] = false;
            currentAssign[i] = -1;
            pri("Worker "+ i+" : ");
            for (int j = 0 ; j < n ; j++){
                cost[i][j] = sc.nextInt();
            }
        }

        solve(0);

        System.out.println("\n--- Result ---");
        for (int i = 0; i < n; i++)
            System.out.println("Worker " + i + " -> Job " + bestAssign[i]);
        System.out.println("Minimum Cost: " + minCost);

        sc.close();
    }
}