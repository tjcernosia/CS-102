import java.util.Arrays;
import java.util.Random;

public class Lab02{

    //Characters that represent the blank and 'treasure' spots
    //on a 'map' (abstracted as a 2D char array).
    private static final char MAP_BLANK = '.';
    private static final char MAP_TREASURE = '$';

    //A Random object you can use for your random number generation!
    //Look at the Java API page for Random:
    //https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
    private static final Random rand = new Random();



    //Start with Problem 2.1 here!
    //public static int[] arrayConcat(....





 public static void main(String[] args){

        //Below are the test cases provided to you in the lab writeup.
        //They are NOT SUFFICIENT!  You must add tests of your own
        //This will make up part of your lab grade!



        //*****  2.1 Tests  *****
        //System.out.println("**Test Array Concat**");
        //int[] arr1 = {7, 3, 14};
        //int[] arr2 = {2, 3, 1};
       
        
        //int[] arr1 = {5, 1, 5};
        //int[] arr2 = {2, 3, 1};

        //System.out.print(Arrays.toString(arr1) + " and " + Arrays.toString(arr2));
        //System.out.println("--> " + Arrays.toString(Lab02.arrayConcat(arr1, arr2)));




        //*****  2.2 Tests  *****
        System.out.println("**Test Only Firsts **");
        String[] arr3 = {"a", "b", "a", "c", "b"};
        String[] arr4 = {"cat", "dog", "CaT", "dog", "FROG"};
        printArr(onlyFirsts(arr4));

        //*****  2.3 Tests  *****
        //System.out.println("**Test Treasure Map **");

        //Replicate the test from the writeup
        //and add more of your own!

    }
    
    public static void printArr(String[] a){
    		System.out.print("[");
    		for(int i = 0; i < a.length; i++) System.out.print(a[i] + ", ");
    		System.out.print("]");
    }
    
    public static int[] arrayConcat(int[] a, int[] b){
    		//make new array of sum of lengths of a and b
    		int[] r = new int[a.length + b.length];
    		//loop through both parameters to add them to new array
    		for(int i = 0; i < r.length; i++){
    			//make sure we're pulling values from the right array
    			if (i < a.length){ r[i] = a[i];}
    			else r[i] = b[i - a.length];
    		}
    		return r;
    }
    
    public static int countDupes(String[] a){
    		//when x == i (happens once for a.length) it will always report it as a duplicate
    		//can just initialize as -a.length
    		int duplicates = -a.length;
    		//check for duplicates
    		for(int i = 0; i < a.length; i++){
    			for(int x = i; x < a.length; x++){
    				if (a[i].toLowerCase().equals(a[x].toLowerCase())) duplicates++;
    			}
    		}
    		return duplicates;
    }
    
    public static boolean contains(String[] a, String b){
    		for(int i = 0; i < a.length; i++){
    			if(a[i] != null && b.toLowerCase().equals(a[i].toLowerCase())) return true;	
    		}
    		//will only reach this return statement if array doesn't contain b
    		return false;
    }
    
    public static String[] onlyFirsts(String[] a){
    		//make new array of final length
    		String[] r = new String[a.length - countDupes(a)];
    		//
    		int index = 0;
    		for(int i = 0; i < a.length; i++){
    			if (!contains(r, a[i])){
    				r[index] = a[i];
    				index++;
    			}
    		}
    		return r;
    }

    public static char[][] createMap(int r, int c){
    		// check to see if either variable is invalid
    		if(r < 1 || c < 1) return new char[0][0];
    		//create new 'map' of correct dimensions
    		char[][] map = new char[r][c];
    		//first loop iterates over rows second over columns
    		for(int i = 0; i < map.length; i++){
    			for(int x = 0; x < map[0].length; x++){
    				//set each index to appropriate value
    				map[i][x] = MAP_BLANK;
    			}
    		}
    		return map;
    }
    
    public static void printMap(char[][] a){
    		//print contents of row on single line
    		for(int r = 0; r < a.length; r++){
    			for(int c = 0; c < a[0].length; c++){
    				System.out.print(a[r][c]);
    			}
    			//line break before printing next row
    			System.out.println();
    		}
    }
    
    public static char[][] buryTreasure(char[][] map, int n){
    		//make a new array to contain paramater array
    		char[][] r = map;
    		for(int i = 0; i < n; i++){
    			int x = rand.nextInt(map.length); 
    			int y = rand.nextInt(map[0].length);
    			//check to see if chosen coordinates already contain '$'
    			//i wont increment until it finds an 'empty' space
    			if (map[x][y] != MAP_TREASURE){
    				map[x][y] = MAP_TREASURE;	
    			} else {
    				i--;
    			}
    		}
    		//return updated map
    		return map; 
    }
}
