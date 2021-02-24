
public class PointClient {
     
     public static void main(String[] args) {
          
          //**** 2.1.1 Getting Started ****
          System.out.println("2.1.1 : default constructor");
          // construct a default Point object named p0
          Point p0 = new Point();
          // print p0
          System.out.println("p0 is: " + p0);
          
          //**** 2.1.2: Translate Coordinates****
          //Test you solution for the translateCoords method below, by calling it on
          //p0 with the arguments 10 and 30, then print p0.
          //Does the output make sense?
          System.out.println("\n2.1.2 : Translate coordinates");
          //test: regular translation
          Point ptranslate = new Point(0,0);
          System.out.println("Before translation: " + ptranslate);
          
          System.out.println("Translation: +10, +10");
          
          ptranslate.translateCoords(10,10);
          System.out.println("After translation: " + ptranslate);
          
          //test: +0 +0 translation
          Point ptranslate1 = new Point(-100,50);
          System.out.println("\nBefore translation: " + ptranslate1);
          
          System.out.println("Translation: +0, +0");
          
          ptranslate1.translateCoords(0,0);
          System.out.println("After translation: " + ptranslate1);
          
          System.out.println("\nThis method is so simple I have no clue how anything could break it");
          
          //**** 2.1.3: Retrieve Individual Coords****
          //Uncomment the print statements below and try to compile/run
          //fix the issue without modifying Point.java!
          
          System.out.println("\n2.1.3 : getter methods");
          
          Point p4 = new Point(5151,123123);
          System.out.println("p4: " + p4);
         
          System.out.println("p4's x coord is: " + p4.getX());
          System.out.println("p4's y coord is: " + p4.getY());
          
          Point p5 = new Point(0,-1219249);
          System.out.println("\np5: " + p5);
          
          System.out.println("p5's x coord is: " + p5.getX());
          System.out.println("p5's y coord is: " + p5.getY());
          
          //**** 2.1.4: Two Argument Constructor ****
          //create two Point objects, p1 at (8, 2) and p2 at (4, 3)
          //Print them to verify their coordinates!
          
          System.out.println("\n2.1.4 : two argument constructor");
          
          System.out.println("Point 1 fields: 8,2");
          System.out.println("Point 2 fields: 4,3");
          
          Point p1 = new Point(8,2);
          Point p2 = new Point(4,3);
          
          System.out.println(p1);
          System.out.println(p2);
          
          //**** 2.1.5: Distance from Origin ****
          System.out.println("\n2.1.5 : distance from origin");
          
          Point dist1 = new Point(3,4);
          Point dist2 = new Point(0,-10);
          Point dist3 = new Point(-15,4);
          Point dist4 = new Point(-1551,-124);
          Point dist5 = new Point(0,0);
          Point dist6 = new Point(414,0);
          
          System.out.println("\n" + dist1 + ": positive x, positive y");
          System.out.println("Distance from origin: " + dist1.distanceFromOrigin());
          
          System.out.println("\n" + dist2 + ": 0 x, negative y");
          System.out.println("Distance from origin: " + dist2.distanceFromOrigin());
          
          System.out.println("\n" + dist3 + ": negative x, positive y");
          System.out.println("Distance from origin: " + dist3.distanceFromOrigin());
          
          System.out.println("\n" + dist4 + ": negative x, negative y");
          System.out.println("Distance from origin: " + dist4.distanceFromOrigin());
          
          System.out.println("\n" + dist6 + ": positive x, 0 y");
          System.out.println("Distance from origin: " + dist6.distanceFromOrigin());
          
          System.out.println("\n" + dist5 + ": 0 x, 0 y");
          System.out.println("Distance from origin: " + dist5.distanceFromOrigin());
          
          System.out.println("\nThe only times distance method will break are when (x * x + y * y) < 0 which is impossible");
          System.out.println("and when (x * x + y * y) becomes too large to handle.");
          System.out.println("Realistically, I think this method is bulletproof");
          
          //**** 2.2.1 and 2.2.2 ****
          //Create test cases to check the quadrant and flip functions
          //Test each function as you implement them!
          System.out.println("\n2.2.1 : quadrant");
          
          Point quad1 = new Point(1,2);
          Point quad2 = new Point(-2,3);
          Point quad3 = new Point(-3,-4);
          Point quad4 = new Point(4,-5);
          Point quad5 = new Point(0,100);
          Point quad6 = new Point(10000,0);
          Point quad7 = new Point(0,0);
          
          System.out.println(quad1 + ": expected in 1st quadrant");
          System.out.println("Quadrant: " + quad1.quadrant());
          
          System.out.println("\n" + quad2 + ": expected in 2nd quadrant");
          System.out.println("Quadrant: " + quad2.quadrant());
          
          System.out.println("\n" + quad3 + ": expected in 3rd quadrant");
          System.out.println("Quadrant: " + quad3.quadrant());
          
          System.out.println("\n" + quad4 + ": expected in 4th quadrant");
          System.out.println("Quadrant: " + quad4.quadrant());
          
          System.out.println("\n" + quad5 + ": expected on y axis");
          System.out.println("Quadrant: " + quad5.quadrant());
          
          System.out.println("\n" + quad6 + ": expected on x axis");
          System.out.println("Quadrant: " + quad6.quadrant());
          
          System.out.println("\n" + quad7 + ": expected on x and y axes");
          System.out.println("Quadrant: " + quad7.quadrant());
          
          System.out.println("\n2.2.2 : flip");
          
          Point flip1 = new Point(1,2);
          Point flip2 = new Point(-2,3);
          Point flip3 = new Point(-3,-4);
          Point flip4 = new Point(4,-5);
          Point flip5 = new Point(0,0);
          
          System.out.println("Before flip : " + flip1);
          flip1.flip();
          System.out.println("After flip : " + flip1 + "\n");
          
          System.out.println("Before flip : " + flip2);
          flip2.flip();
          System.out.println("After flip : " + flip2 + "\n");
          
          System.out.println("Before flip : " + flip3);
          flip3.flip();
          System.out.println("After flip : " + flip3 + "\n");
          
          System.out.println("Before flip : " + flip4);
          flip4.flip();
          System.out.println("After flip : " + flip4 + "\n");
          
          System.out.println("Before flip : " + flip5);
          flip5.flip();
          System.out.println("After flip : " + flip5 + "\n");
     }
}
