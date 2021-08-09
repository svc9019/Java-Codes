public class Rectangle {
   double width;
   double height;

   Rectangle(double width, double height) {
       this.width = width;
       this.height = height;
   }

   public void area() {
       System.out.println("Area of Rectangle is: " +  (width * height) ) ;
   }

   public void perimeter() {
       System.out.println("Perimeter of Rectangle is: " + ( (2 * width) + (2 * height) ) ) ;
   }
}

class Square extends Rectangle {  
   Square(double side) {
       super(side, side);  
   }

   public void area() {
       System.out.println("Area of Square is: " +  (super.width * super.width) ) ;
   }

   public void perimeter() {
       System.out.println("Perimeter of Square is: " + ( 4 * super.width) ) ;
   }
}