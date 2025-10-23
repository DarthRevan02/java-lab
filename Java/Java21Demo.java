// Java 21 Simple Demo
public class Java21Demo {
    // Record declaration (available since Java 14)
    record Point(int x, int y) {
        public double distanceFromOrigin() {
            return Math.sqrt(x * x + y * y);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Java 21 Demo ===");
        System.out.println("Running on Java version: " + System.getProperty("java.version"));
        
        // 1. Text Blocks
        demonstrateTextBlocks();
        
        // 2. Records
        demonstrateRecords();
        
        // 3. Enhanced instanceof
        demonstrateInstanceof();
        
        System.out.println("\nJava 21 upgrade successful!");
    }
    
    static void demonstrateTextBlocks() {
        System.out.println("\n1. Text Blocks:");
        String message = """
                Welcome to Java 21!
                This is a text block that preserves
                formatting and makes multi-line strings
                much easier to work with.
                """;
        System.out.println(message);
    }
    
    static void demonstrateRecords() {
        System.out.println("2. Records:");
        Point p1 = new Point(3, 4);
        Point p2 = new Point(0, 0);
        
        System.out.println("Point 1: " + p1);
        System.out.println("Point 1 distance from origin: " + p1.distanceFromOrigin());
        System.out.println("Point 2: " + p2);
        System.out.println("Point 2 distance from origin: " + p2.distanceFromOrigin());
    }
    
    static void demonstrateInstanceof() {
        System.out.println("\n3. Enhanced instanceof:");
        Object obj = "Hello Java 21";
        
        if (obj instanceof String str) {
            System.out.println("String length: " + str.length());
            System.out.println("Uppercase: " + str.toUpperCase());
        }
        
        obj = 42;
        if (obj instanceof Integer num) {
            System.out.println("Integer value: " + num);
            System.out.println("Double value: " + (num * 2));
        }
    }
}