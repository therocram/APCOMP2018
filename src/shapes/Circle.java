// Solution to Project 10.3
package shapes;

import TurtleGraphics.Pen;

// This class extends AbstractShape and in the process implements
// the Shape interface.

public class Circle extends AbstractShape {

   protected double radius;

   public Circle() {
      super();              // Activate a constructor in AbstractShape.
      radius = 1;           // Then initialize radius.
   }

   public Circle (double xLoc, double yLoc, double r) {
      super (xLoc, yLoc);   // Activate a constructor in AbstractShape.
      radius = r;           // Then initialize radius.
   }
 
   // The next three methods were abstract in the superclass.
   // Now we define them.

   public double area() {
      return Math.PI * radius * radius;
   }

   public double perimeter(){
	  return 2 * Math.PI * radius; 
   }

   public void draw (Pen p) {
      double side = 2.0 * Math.PI * radius / 120.0;
      p.up();
      p.move (xPos + radius, yPos - side / 2.0);
      p.setDirection (90);
      p.down();
      for (int i = 0; i < 120; i++){
         p.move (side);
         p.turn (3);
      }
   }

   public void stretchBy (double factor) {
      radius *= factor;
   }

   // Notice that the toString method calls the corresponding method in the
   // superclass in order to accomplish its task.
   
   // In the superclass, the toString method calls area, which will activate
   // the area method in this class and not the area method in the superclass.

   public String toString() {
      String str = "CIRCLE\n"
                 + "Radius: " + radius + "\n"
                 + super.toString();
      return str;
   }
}

