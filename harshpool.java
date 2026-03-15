package AA;

import java.util.HashMap;
import java.util.Scanner;

public class harshpool {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String text = sc.next();
        String pattern = sc.next();
        int m = pattern.length();
        int n = text.length();
        HashMap<Character , Integer> BT = new HashMap<>();

        for (int i = 0; i < m -1 ; i++){
            BT.put(pattern.charAt(i) , m -1 - i);
        }
        
        boolean found = false;

        int i = m-1;

        while ( i < n) {

            int j = 0;
            while (j < m && pattern.charAt(m-1-j) == text.charAt(i-j)) {
                j++;
            }
            if (j == m){
                System.out.println("pattern found at " + (i-m+2));
                found = true;
                break;
            }
            i += BT.getOrDefault(text.charAt(i), m);
            
        }

        if (! found){
            System.out.println("Not found");
        }


        sc.close();
    }
    
}
