import java.util.Scanner;
class Shapes {
    double area;

    Shapes() {
        area = 0;
    }

    Shapes(double side) { // Square
        area = side * side;
        System.out.println("Area of Square: " + area);
    }

    Shapes(double length, double breadth) { // Rectangle
        area = length * breadth;
        System.out.println("Area of Rectangle: " + area);
    }

    void findArea(double radius) { // Circle
        area = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + area);
    }

    void findArea(double base, double height, boolean isTriangle) { // Triangle
        if (isTriangle) {
            area = 0.5 * base * height;
            System.out.println("Area of Triangle: " + area);
        }
    }
}

public class lab3_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Square
        System.out.print("Enter side of square: ");
        double side = sc.nextDouble();
        Shapes s1 = new Shapes(side);

        // Rectangle
        System.out.print("Enter length of rectangle: ");
        double length = sc.nextDouble();
        System.out.print("Enter breadth of rectangle: ");
        double breadth = sc.nextDouble();
        Shapes s2 = new Shapes(length, breadth);

        // Circle
        Shapes s3 = new Shapes();
        System.out.print("Enter radius of circle: ");
        double radius = sc.nextDouble();
        s3.findArea(radius);

        // Triangle
        System.out.print("Enter base of triangle: ");
        double base = sc.nextDouble();
        System.out.print("Enter height of triangle: ");
        double height = sc.nextDouble();
        s3.findArea(base, height, true);

        sc.close();
    }
}

