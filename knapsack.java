package AA;
import java.util.Arrays;
import java.util.Scanner;

public class knapsack {

    static Item[] items ;
    static int capacity,n;

    static class Item {
        int weight , value ;
        double ratio;
        Item(int a , int b){
            weight = b;
            value = a;
            ratio = value/weight;
        }
    }

    private static double knapsack1(){
        double totalValue = 0;

        Arrays.sort( items , (o1, o2) -> Double.compare(o2.ratio, o1.ratio));

        int remaining = capacity;

        for (Item i : items){
            if (remaining == 0) break;

            if (remaining >= i.weight){
                remaining -= i.weight;
                totalValue += i.value;
            } 
            else {
                double fraction =(double) remaining/i.weight;
                remaining = 0;

                totalValue += fraction*i.value;
                System.out.println("came "+ remaining + totalValue + fraction*i.value);
            }
        }


        return totalValue;
    }



    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items   : ");
        n = sc.nextInt();

        System.out.print("Enter knapsack capacity : ");
        capacity = sc.nextInt();

        items = new Item[n];
        System.out.println("Enter the value and weight for items");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " : ");
            items[i] = new Item(sc.nextInt(), sc.nextInt());
        }

        double totalValue = knapsack1();

        System.out.printf("%nTotal Value : %.2f%n", totalValue);

        sc.close();

    }
}
