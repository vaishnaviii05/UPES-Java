import java.util.Scanner;

// Shape Interface with area() method
interface Shape {
    double area();
}

// Circle Class implementing Shape interface
class Circle implements Shape {
    private final double radius;
    private final double pi = 3.14159;

    // Constructor
    public Circle(final double radius) {
        this.radius = radius;
    }

    // Implementing the area() method
    @Override
    public double area() {
        return pi * radius * radius;
    }
}

// Rectangle Class implementing Shape interface
class Rect implements Shape {
    private final double length;
    private final double width;

    // Constructor
    public Rect(final double length, final double width) {
        this.length = length;
        this.width = width;
    }

    // Implementing the area() method
    @Override
    public double area() {
        return length * width;
    }
}

// Triangle Class implementing Shape interface
class Tri implements Shape {
    private double base;
    private double height;

    // Constructor
    public Tri(final double base, final double height) {
        this.base = base;
        this.height = height;
    }

    // Implementing the area() method
    @Override
    public double area() {
        return 0.5 * base * height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(final double height) {
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(final double base) {
        this.base = base;
    }
}

// AreaCalculator Class to calculate area using polymorphism
class AreaCalc {

    // Method to calculate area of a shape using polymorphism
    public void calcArea(final Shape shape) {
        System.out.println("The area of the shape is: " + shape.area());
    }
}

// Main class to run the program
public class ShapeAreaCalc {

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final AreaCalc calc = new AreaCalc();
        Shape shape = null;

        // Menu-driven program
        while (true) {
            System.out.println("Choose a shape to calculate the area:");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Exit");
            final int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    // Circle area calculation
                    System.out.print("Enter the radius of the circle: ");
                    final double radius = scanner.nextDouble();
                    shape = new Circle(radius);
                    calc.calcArea(shape);
                }
                case 2 -> {
                    // Rectangle area calculation
                    System.out.print("Enter the length of the rectangle: ");
                    final double length = scanner.nextDouble();
                    System.out.print("Enter the width of the rectangle: ");
                    final double width = scanner.nextDouble();
                    shape = new Rect(length, width);
                    calc.calcArea(shape);
                }
                case 3 -> {
                    // Triangle area calculation
                    System.out.print("Enter the base of the triangle: ");
                    final double base = scanner.nextDouble();
                    System.out.print("Enter the height of the triangle: ");
                    final double height = scanner.nextDouble();
                    shape = new Tri(base, height);
                    calc.calcArea(shape);
                }
                case 4 -> {
                    // Exit
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
            System.out.println();
        }
    }

    public ShapeAreaCalc() {
    }
}
