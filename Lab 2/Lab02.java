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

 public static void main(String[] args){

        //Below are the test cases provided to you in the lab writeup.
        //They are NOT SUFFICIENT!  You must add tests of your own
        //This will make up part of your lab grade!



        //*****  2.1 Tests  *****
        System.out.println("**Test Array Concat**");
        
        System.out.println("general case: \n");
        int[] arr7 = {18, 0, 999999};
        int[] arr8 = {140,12,4124,1523512,51,25,125};
        
        System.out.print("arr1: "); printIntArr(arr7); 
        System.out.print(" arr2: "); printIntArr(arr8); 
        System.out.println("\noutput: ");
        printIntArr(arrayConcat(arr7,arr8));
        System.out.println("\n");
        
        System.out.println("edgecase: one or more empty arrays\n");
        int[] arr1 = {7, 3, 14};
        int[] arr2 = {};

        System.out.print("arr1: "); printIntArr(arr1); 
        System.out.print(" arr2: "); printIntArr(arr2); 
        System.out.println("\noutput: ");
        printIntArr(arrayConcat(arr1,arr2));
        System.out.println("\n");
        
        int[] arr6 = {};
        int[] arr5 = {};
        
        System.out.print("arr1: "); printIntArr(arr6); 
        System.out.print(" arr5: "); printIntArr(arr5); 
        System.out.println("\noutput: ");
        printIntArr(arrayConcat(arr6,arr5));
        System.out.println("\n");


        //*****  2.2 Tests  *****
        System.out.println("**Test Only Firsts **");
        String[] arr3 = {"a", "b", "a", "c", "b"};
        String[] arr4 = {"cat", "dog", "CaT", "dog", "FROG"};
        
        //test arr3
        System.out.print("input (general test): \n"); 
        printStringArr(arr3); 
        System.out.println("\noutput: ");
        printStringArr(onlyFirsts(arr3));
        System.out.println("\n");
        
        //test arr4
        System.out.print("input (different capitalization): \n"); 
        printStringArr(arr4); 
        System.out.println("\noutput: ");
        printStringArr(onlyFirsts(arr4));
        System.out.println("\n");

        //*****  2.3 Tests  *****
        System.out.println("**Test Treasure Map **");
        //generate 10 random treasure maps with different x, y, and n values
        System.out.println("bulk test randomly generated treasure maps");
        for(int i = 0; i < 10; i++){
        		int x = rand.nextInt(9)+1;
        		int y = rand.nextInt(9)+1;
        		int n = rand.nextInt(x * y);
        		System.out.println("rows: " + x + " columns: " + y + " treasure: " + n);
        		printMap(buryTreasure(createMap(x,y),n));
        		System.out.println();
        }
        
        System.out.println("\nedgecase: treasure count is greater than dimensions of map");
        System.out.println("rows: 5 columns: 5 treasure: 110");
        printMap(buryTreasure(createMap(5,5),110));
        System.out.println();
        
        System.out.println("\nedgecase: treasure count is less than 0");
        System.out.println("rows: 5 columns: 5 treasure: -5");
        printMap(buryTreasure(createMap(5,5),-5));
        System.out.println();
        
        System.out.println("\nedgecase: one or more dimensions is less than one");
        System.out.println("rows: 0 columns: 1 treasure: 110");
        printMap(buryTreasure(createMap(0,1),110));
        //Replicate the test from the writeup
        //and add more of your own!
    }
    
    public static char[][] copyCharArr(char[][] a){
    		if(a.length < 1 || a[0].length < 1) return a;
    		char[][] n = new char[a.length][a[0].length];
    		for(int r = 0; r < a.length; r++){
    			for(int c = 0; c < a[0].length; c++){
    				n[r][c] = a[r][c];
    			}
    		}
    		return n;
    }
    
    public static void printIntArr(int[] a){
    		System.out.print("[");
    		for(int i = 0; i < a.length; i++) System.out.print(a[i] + ", ");
    		System.out.print("]");
    }
    
    public static void printStringArr(String[] a){
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
    		//when x == i (happens every time second loop iterates) it will always report it as a duplicate
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
    			//makes sure a[i] isn't null so that .toLowerCase() doesn't throw nullpointer 
    			if(a[i] != null && b.toLowerCase().equals(a[i].toLowerCase())) return true;	
    		}
    		//will only reach this return statement if array doesn't contain b
    		return false;
    }
    
    public static String[] onlyFirsts(String[] a){
    		//make new array of correct length
    		String[] r = new String[a.length - countDupes(a)];
    		//create int to store what index of the return array we're on
    		int index = 0;
    		for(int i = 0; i < a.length; i++){
    			//we only advance index if a[i] isn't already inside of it using helper function contains()
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
    		//make sure the map isn't broken
    		if(map.length < 1 || map[0].length < 1) return map;
    		if(n < 0 || n > map.length * map[0].length) return map; 
    		//make a new array to contain parameter array
    		char[][] r = copyCharArr(map);
    		for(int i = 0; i < n; i++){
    			int x = rand.nextInt(map.length); 
    			int y = rand.nextInt(map[0].length);
    			//check to see if chosen coordinates already contain '$'
    			//i wont increment until it finds an 'empty' space
    			if (r[x][y] != MAP_TREASURE){
    				r[x][y] = MAP_TREASURE;	
    			} else {
    				i--;
    			}
    		}
    		//return updated map
    		return r; 
    }
}
