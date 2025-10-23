// Java 21 Features Demo
public class Java21Features {
    public static void main(String[] args) {
        System.out.println("=== Java 21 Features Demo ===");
        System.out.println("Running on Java version: " + System.getProperty("java.version"));
        
        // 1. Text Blocks (from Java 15, fully stable in 21)
        demonstrateTextBlocks();
        
        // 2. Simple Virtual Threads demo (Major feature in Java 21)
        demonstrateVirtualThreads();
        
        // 3. Records (from Java 14, fully stable)
        demonstrateRecords();
    }
    
    static void demonstratePatternMatching() {
        System.out.println("\n1. Pattern Matching for switch:");
        Object obj = "Hello World";
        
        String result = switch (obj) {
            case String s when s.length() > 5 -> "Long string: " + s;
            case String s -> "Short string: " + s;
            case Integer i -> "Integer: " + i;
            case null -> "Null value";
            default -> "Unknown type";
        };
        
        System.out.println(result);
    }
    
    // Record for demonstration
    record Point(int x, int y) {}
    
    static void demonstrateRecordPatterns() {
        System.out.println("\n2. Record Patterns:");
        Point point = new Point(3, 4);
        
        switch (point) {
            case Point(int x, int y) when x == 0 && y == 0 -> 
                System.out.println("Origin point");
            case Point(int x, int y) -> 
                System.out.println("Point at (" + x + ", " + y + ")");
        }
    }
    
    static void demonstrateTextBlocks() {
        System.out.println("\n3. Text Blocks:");
        String json = """
            {
                "name": "Java 21",
                "version": "21.0.8",
                "features": [
                    "Virtual Threads",
                    "Pattern Matching",
                    "Record Patterns"
                ]
            }
            """;
        System.out.println(json);
    }
    
    static void demonstrateVirtualThreads() {
        System.out.println("\n4. Virtual Threads:");
        
        // Create and run virtual threads
        for (int i = 1; i <= 3; i++) {
            final int threadNum = i;
            Thread.ofVirtual().start(() -> {
                System.out.println("Virtual Thread " + threadNum + " is running");
                try {
                    Thread.sleep(100); // Simulate some work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Virtual Thread " + threadNum + " completed");
            });
        }
        
        // Give threads time to complete
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("All virtual threads have been started");
    }
}