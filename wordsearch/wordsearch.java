import java.util.Arrays;
import java.util.Scanner;
import java.lang.Character;
import java.io.File;
import java.io.FileNotFoundException;

public class wordsearch{
	
	public static final char[][] BOARD = createBoard();
	public static final String SOURCE = "tsbncsebiaasnatldiquargaiopomfncesih";
	public static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String PROMPT = "Guess something";
	private static final char STOP = '$';
	
	private static final char[] KEYS = {'a', 'w', 'd', 'x', 'q', 'e', 'c', 'z'};
    private static final int[] Y_DIR = { 0, -1, 0, 1, -1, 1, 1, -1};
    private static final int[] X_DIR = {-1, 0, 1, 0, -1, -1, 1, 1};
	
	public static int x;
	public static int y;
	public static char[][] displayBoard = createBoard();
	public static String guess = "";
	
	public static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException{
		
	}
	
	private static char getChar() {
        
        if (console.hasNextLine()) {
            String line = console.nextLine().toUpperCase();
            return line.charAt(0);
        }
        
        return '?';
    }
    
    private static int getCol(String prompt) {
        System.out.println(prompt);
      
        char letter = 'z';
        boolean inRange = false;
        
        while (console.hasNextLine() && !inRange) {
            letter = getChar();
            System.out.println("You typed " + (char)letter);
            if (letter >= 'A' && letter <='D') {
                inRange = true;
            	System.out.println("In my range! goodbye");
            	break;
        	} else  {
                System.out.println("Letter not in my arbitrary range, i.e. " 
                	+ 'A' + " to "+  "D \ntry again...");
                System.out.print(prompt);
            }
        }
        return letter-'A';
    }   
	
	public static int getInt(){
		return 0;	
	}
	
	public static char[][] createBoard(){
		/*
		//create new map of correct dimensions
		char[][] map = new char[NUMROW][NUMCOL];
		
		//set word search indexes to corresponding letter in SOURCE
		for(int r = 0; r < map.length; r++){
			for(int c = 0; c < map[0].length; c++){
				map[r][c] = SOURCE.charAt(map.length * r + c);
			}
		}
		return map; 
		*/
		Scanner input = new Scanner(new File("grid.txt"));
		int numRows = 0;
		int numCol = input.next().toCharArray().length;
		
		for(; input.hasNextLine(); input.nextLine()){
			numRows++;
		}
		
		return new char[1][1];
	}
	
	// prints out the board with sidebars
	public static void printBoard(){
		//print out letters at top of word search
		System.out.println("  " + LETTERS.substring(0,BOARD.length));
		
		for(int r = 0; r < BOARD.length; r++){
			//print out row number and appropriate space
			System.out.print(r + " ");
			//print out row
			for(int c = 0; c < BOARD[0].length; c++){
				System.out.print(displayBoard[r][c]);
			}
			System.out.println();
		}
	}
	
	// prints cursor position in a readable way
	public static void printPosition(){
		System.out.println("Cursor is at: " + Character.toUpperCase(LETTERS.charAt(y)) + x);
	}
	
	// changes BOARD[x][y] to '*'
	public static void updateDisplay(){
		displayBoard[x][y] = '*';
	}
	
	// appends BOARD[x][y] to String guess
	public static void updateGuess(){
		guess += BOARD[x][y];	
	}
	
	// returns boolean so we can use its return to see if the move has failed
	public static boolean move(char m){
		//pre-process to make sure char is lowercase
		m = Character.toLowerCase(m);
		
		return true;
	}
	
	public static boolean checkMove(){
		return true;
	}
	
}