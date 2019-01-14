// Solution to Project 10.3
package shapes;

public class TestShapes {
   public static void main (String[] args) {

      // Instantiate a circle, a wheel, and a rectangle
      Shape s1 = new Circle (20, 20, 20);
      Shape s2 = new Wheel (20, 20, 20, 6);
      Shape s3 = new Rect(20, 20, 10, 10);

      System.out.println("Perimeter of circle: " +
                         s1.perimeter() + "\n" +
                         "Perimeter of wheel: " +
                         s2.perimeter() + "\n" +
                         "Perimeter of rectangle: " +
                         s3.perimeter());

   }

}

