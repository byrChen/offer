
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int k = sc.nextInt();
            System.out.println(helper(s, k, s.length()-1), s.length());
            sc.nextLine();
        }
    }

    private static int helper(String s, int k, int end, int tail) {
        if (end == -1) return k == 0 ? 1 : 0;
        int plans = 0;
        for (int i = end+1; i <= tail; i++) {
            String substr = s.substring(end, i);
            int val = Integer.valueOf((substr));
            plans += helper(s, k-val, end-1,);
            plans += helper(s, k+val, end-1);
        }
        return plans;
    }
}
