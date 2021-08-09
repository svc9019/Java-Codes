import java.util.*;

class Shape {
    public void display() {
        System.out.println("display method overridding");
    }

    public static void print() {
        System.out.println("The shape is a circle");
    }
}

class Triangle extends Shape {
    public void display() {
        System.out.println("The shape is a triangle");
    }
}

class Rectangle extends Shape {
    public void display() {
        System.out.println("The shape is a rectangle");
    }
}

public class Source {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Shape obj = new Triangle();
        Shape obj1 = new Rectangle();
        int numberOfSides = in.nextInt();

        switch (numberOfSides) {
            case 0:
                obj.print();
                break;
            case 3:
                obj.display();
                break;
            case 4:
                obj1.display();
                break;
            default:
                System.out.println("Enter a valid number of sides!");
                break;
        }
    }
}
