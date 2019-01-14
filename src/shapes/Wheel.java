// Solution to Project 10.3
package shapes;

import TurtleGraphics.Pen;

public class Wheel extends Circle {

   private int spokes;    // The number of spokes in the wheel
                          // xPos, yPos, and radius are inherited from Circle

   public Wheel() {
      super();            // Activate the constructor Circle() to 
                          // initialize xPos, yPos, and radius.
      spokes = 0;         // Now initialize spokes.
   }

   public Wheel (double xLoc, double yLoc, double r, int s) {
      super (xLoc, yLoc, r);  // Activate the constructor
                              // Circle (double xLoc, double yLoc, double r)
                              // to initialize xPos, yPos, and radius.
      spokes = s;             // Now initialize spokes.
   }
 
   public void draw (Pen p) {
      // Draw the wheel's rim by calling the draw method in the superclass.
      super.draw (p);
      
      // Draw the spokes
      for (int i = 1; i <= spokes; i++){
         p.up();
         p.move (xPos, yPos);
         p.setDirection (i * 360.0 / spokes);
         p.down();
         p.move (radius);
      }      
   }
   
   public void setSpokes (int s) {
      spokes = s;
   }

   public String toString() {
      String str = "WHEEL\n"
                 + "Radius: " + radius + "\n"
                 + "Spokes: " + spokes + "\n"
                 + "(X,Y) Position: (" + xPos + "," + yPos + ")\n" 
                 + "Area: " + area();
      return str;
   }
}

