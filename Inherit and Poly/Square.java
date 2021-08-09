class Square extends Rectangle {?
?   Square(double side) {?
?      super(side, side); ?
?   }?
??
   public void area() {?
      System.out.println("Area of Square is: " + (super.getWidth() * super.getWidth()) ) ;?
   }?

   public void perimeter() {?
      System.out.println("Perimeter of Square is: " + ( 4 * super.getWidth()));
   }?
?}