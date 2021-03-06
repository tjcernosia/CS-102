
public class Point {

     private int x;                                   // Each Point object has
     private int y;                                   // an int x and y inside.

     
      //*** For 2.1.4 ***
      // Add the appropriate constructor that takes two int values
      
     public Point(){};

     public Point(int x, int y){
     	 this.x = x;
      	 this.y = y;
      }

     public String toString() {
         return "Point at (" + this.x + ", " + this.y + ")";
     }


     public int getX(){
     	 return this.x;
     }

     public int getY(){
         return this.y;
     }

      //*** For 2.1.2 ***
      //Shifts this point's x and y coordinates by deltaX and deltaY, respectively.
      public void translateCoords(int deltaX, int deltaY) {
      	  this.x += deltaX;
      	  this.y += deltaY;
      }
     
      //*** For 2.1.5 ***
      //Calculates the distance of this point to the origin (0,0)
      public double distanceFromOrigin() {
      	   return Math.sqrt(x * x + y * y);           
      }
           
      //*** For 2.2.1 ***
      //Implement the quadrant() method.
      //Returns which quadrant of the xy-plane this Point object falls in
      public int quadrant(){
      	  //didnt like this first method declaration because it's not readable at all
      	  /*
      	  //check if they're on axes
      	  if (x == 0 || y == 0) return 0;
      	  //if x * y > 0 then it must be either quadrant 1 or 3
      	  if (x * y > 0){
      	  	  // if it's not quadrant 3 it must be quadrant 1
      	  	  if (x < 0) return 3; 
      	  	  return 1;
      	  }
      	  //same but repeated
      	  if (x < 0) return 2;
      	  return 4;
      	  */
      	  //can't figure out a way to cleaner, more readable way to find quadrant 
      	  if(x > 0 && y > 0) return 1; 
      	  if(x < 0 && y > 0) return 2; 
      	  if(x < 0 && y < 0) return 3; 
      	  if(x > 0 && y < 0) return 4;
      	  return 0;
      	  
      }

      //*** For 2.2.2 ***
      //Implement the flip() method.
      //Negates and swaps the xy-coordinates of this Point object.
      public void flip(){
      	  //assigns temporary variable so x isn't overwritten 
      	  int temp = x;
      	  x = y *= -1;
      	  y = temp *= -1;
      }
      





}
