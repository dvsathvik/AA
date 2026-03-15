package AA;
import java.lang.Math;
import java.util.Scanner;

public class multiplication {

    private static long karatsuba(long x, long y) {
        if (x < 10 || y < 10) {
            return x * y;
        }

        int n = Math.max(String.valueOf(x).length(),
                         String.valueOf(y).length());

        int half = n / 2;
        long splitPoint = (long) Math.pow(10, half);

        long a = x / splitPoint;  // high of x
        long b = x % splitPoint;  // low  of x

        long c = y / splitPoint;  // high of y
        long d = y % splitPoint;  // low  of y

        long ac         = karatsuba(a, c);                        // ✅ fixed
        long bd         = karatsuba(b, d);
        long ad_plus_bc = karatsuba(a + b, c + d) - ac - bd;

        return (ac * (long) Math.pow(10, 2 * half))
             + (ad_plus_bc * (long) Math.pow(10, half))
             + bd;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two Numbers :");  // ✅ fixed
        long a = sc.nextLong();   // ✅ use long, not int
        long b = sc.nextLong();   // ✅ use long, not int

        System.out.println(karatsuba(a, b));  // ✅ fixed
        sc.close();
    }
}