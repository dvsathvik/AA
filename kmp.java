package AA;

import java.util.Scanner;

public class kmp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.next();
        String pattern = sc.next();

        int[] LPS = new int[pattern.length()];
        LPS[0] = 0;
        int j = 0, i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                LPS[i] = j + 1;
                i++;
                j++;
            } else {
                if (j == 0) {
                    LPS[i++] = 0;
                } else {
                    j = LPS[j-1];
                }
            }
        }

        j = 0;
        i = 0;
        boolean found = false;
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = LPS[j-1];
                }
            }
            
            if (j == pattern.length()){
                System.out.println("pattern found at " + (i-j+1));
                found = true;
                break;
            }
        }
        
        if (!found){
            System.out.println("pattern not found");
        }

        sc.close();
    }
}
