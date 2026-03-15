package AA;

import java.util.Scanner;

public class Rabin_Karp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text    : ");
        String text = sc.next();
        System.out.print("Enter pattern : ");
        String pattern = sc.next();

        int d = 256;
        int q = 101;
        int h = 1;
        int m = pattern.length();
        int n = text.length();

        for (int i = 0; i < m - 1; i++)
            h = (h * d) % q;

        int testhash = 0, patternHash = 0;

        for (int i = 0; i < m; i++) {
            patternHash = (d * patternHash + pattern.charAt(i)) % q;
            testhash    = (d * testhash    + text.charAt(i))    % q;
        }

        System.out.println("\n--- Search Process ---");

        boolean found = false;

        for (int start = 0; start <= n - m; start++) {  

            if (testhash == patternHash) {

                boolean match = true;
                for (int k = 0; k < m; k++) {
                    if (pattern.charAt(k) != text.charAt(start + k)) {
                        match = false;
                        System.out.println("Spurious hit at index " + start);
                        break;
                    }
                }

                if (match) {
                    System.out.println("Pattern found at index " + (start+1));
                    found = true;
                }
            }

            if (start < n - m) {
                testhash = (d * (testhash - text.charAt(start) * h)
                           + text.charAt(start + m)) % q;

                if (testhash < 0)
                    testhash += q;
            }
        }

        if (!found)
            System.out.println("Pattern not found!");

        sc.close();
    }
}
