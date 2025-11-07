import java.util.Scanner;

class OutOfRangeException extends Exception {
    public OutOfRangeException(String message) {
        super(message);
    }
}

public class SpiralNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Enter a number: ");
            int n = sc.nextInt();
            
            if (n < 10 || n > 15) {
                throw new OutOfRangeException("Number is out of range! Must be between 10 and 15.");
            }
            
            // Generate spiral pattern
            System.out.println("\nSpiral Pattern for " + n + ":");
            generateSpiral(n);
            
        } catch (OutOfRangeException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
    
    public static void generateSpiral(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        
        while (top <= bottom && left <= right) {
            // Fill top row
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;
            
            // Fill right column
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;
            
            // Fill bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--;
            }
            
            // Fill left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }
        
        // Print the spiral matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
