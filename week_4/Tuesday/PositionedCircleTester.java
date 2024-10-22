class PositionedCircle {
    public double x;
    public double y;
    public double radius;

    // Default Constructor
    public PositionedCircle() {
        this.x = 0.0;
        this.y = 0.0;
        this.radius = 0.0;
    }

    // Parameterized Constructor
    public PositionedCircle(double radius, double x, double y) {
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    // Overloaded Constructor
    public PositionedCircle(double radius) {
        this(radius, 0.0, 0.0);
    }

    public boolean inside(double x0, double y0) {
        double distanceSquared = (x0 - x) * (x0 - x) + (y0 - y) * (y0 - y);
        return distanceSquared <= radius * radius;
    }

    public static boolean overlap(PositionedCircle c1, PositionedCircle c2) {
        double distanceSquared = (c1.x - c2.x) * (c1.x - c2.x) + (c1.y - c2.y) * (c1.y - c2.y);
        double radiusSum = c1.radius + c2.radius;
        return distanceSquared <= radiusSum * radiusSum;
    }
}

public class PositionedCircleTester {
    public static void main(String[] args) {
        // Test default constructor
        PositionedCircle circle1 = new PositionedCircle();
        System.out.println("Default constructor:");
        System.out.println("x: " + circle1.x + ", y: " + circle1.y + ", radius: " + circle1.radius);

        // Test parameterized constructor
        PositionedCircle circle2 = new PositionedCircle(5.0, 3.0, 4.0);
        System.out.println("\nParameterized constructor:");
        System.out.println("x: " + circle2.x + ", y: " + circle2.y + ", radius: " + circle2.radius);

        // Test overloaded constructor
        PositionedCircle circle3 = new PositionedCircle(10.0);
        System.out.println("\nOverloaded constructor:");
        System.out.println("x: " + circle3.x + ", y: " + circle3.y + ", radius: " + circle3.radius);

        // Test inside method
        boolean isInside = circle2.inside(4.0, 5.0);
        System.out.println("\nInside method test:");
        System.out.println("Point (4.0, 5.0) inside circle2: " + isInside);

        // Test overlap method
        boolean isOverlap = PositionedCircle.overlap(circle2, circle3);
        System.out.println("\nOverlap method test:");
        System.out.println("Circle2 overlaps with circle3: " + isOverlap);
    }
}