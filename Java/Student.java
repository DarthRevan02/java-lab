import java.util.Scanner;

public class Student {
    String name;
    String city;
    int age;

    public Student(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public void printData() {
        System.out.println("Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for S1
        System.out.print("Enter name for S1: ");
        String name1 = sc.nextLine();
        System.out.print("Enter city for S1: ");
        String city1 = sc.nextLine();
        System.out.print("Enter age for S1: ");
        int age1 = sc.nextInt();
        sc.nextLine(); // consume newline

        // Input for S2
        System.out.print("Enter name for S2: ");
        String name2 = sc.nextLine();
        System.out.print("Enter city for S2: ");
        String city2 = sc.nextLine();
        System.out.print("Enter age for S2: ");
        int age2 = sc.nextInt();

        Student S1 = new Student(name1, city1, age1);
        Student S2 = new Student(name2, city2, age2);

        System.out.println("\nDetails of: " + S1.name);
        S1.printData();

        System.out.println("\nDetails of: " + S2.name);
        S2.printData();

        sc.close();
    }
}
