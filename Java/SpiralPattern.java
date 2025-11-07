import java.util.*;
public class SpiralPattern {
    public static void main(String[] args) {
        int n = 0;
        if (args.length >= 1) {
            try {
                n = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid integer argument, falling back to stdin.");
            }
        }
        if (n <= 0) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter n: ");
            if (sc.hasNextInt()) n = sc.nextInt();
            sc.close();
        }
        if (n <= 0) {
            System.err.println("n must be a positive integer.");
            return;
        }
        int[][] a = new int[n][n];
        int num = 1;
        for (int s = 0; s <= 2 * (n - 1); s++) {
            if (s % 2 == 0) {
                // for even s: traverse rows from 0..n-1
                for (int r = 0; r < n; r++) {
                    int c = s - r;
                    if (c >= 0 && c < n) {
                        a[r][c] = num++;
                    }
                }
            } else {
                // for odd s: traverse rows from n-1..0
                for (int r = n - 1; r >= 0; r--) {
                    int c = s - r;
                    if (c >= 0 && c < n) {
                        a[r][c] = num++;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j]);
                if (j < n - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}