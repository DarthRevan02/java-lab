import java.util.Scanner;

public class AreaTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter base of triangle: ");
        double base = scanner.nextDouble();

        System.out.print("Enter height of triangle: ");
        double height = scanner.nextDouble();

        double area = 0.5 * base * height;
        System.out.println("Area of triangle: " + area);

        scanner.close();
    }
}
