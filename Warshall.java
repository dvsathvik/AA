package AA;

import java.util.Scanner;

public class Warshall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of  vertices : ");
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        System.out.println("Enter veritces matrix :");
        for (int i = 0; i < n ; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int k = 0; k < n ; k++){
            for (int i = 0; i < n ; i++){
                for (int j = 0; j < n; j++){
                    if ((matrix[i][j] != 1) && (matrix[i][k] == 1) && (matrix[k][j] == 1)){
                        matrix[i][j] = 1;
                    }
                }
            }
        }

        System.out.println("Final :");
        for (int i = 0; i < n ; i++){
            for (int j = 0; j < n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }    
}
