import java.util.Arrays;
import java.util.Scanner;
import java.lang.Character;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.StringBuilder;

public class wordsearch{
	
	public static final char[][] BOARD = createBoard();
	public static final String SOURCE = "tsbncsebiaasnatldiquargaiopomfncesih";
	public static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String PROMPT = "Which direction do you want to move: ";
	private static final char STOP = '$';
	public static final int NUMROW = 6;
	public static final int NUMCOL = 6;
	
	public static Scanner console = new Scanner(System.in);
	public static StringBuilder bld = new StringBuilder();
	
	private static final char[] KEYS = {'a', 'w', 'd', 'x', 'q', 'e', 'c', 'z'};
    private static final int[] X_DIR = { 0 ,  -1,  0 ,  1 , -1 , -1 ,  1 ,  1 };
    private static final int[] Y_DIR = {-1 ,   0,   1,   0,  -1,  1 ,  1 , -1 };
    
    private static final String[] NAMES = {"bianca", "portia", "quince", "iago"};
	
	public static int x;
	public static int y;
	public static boolean gameOn = true;
	public static char[][] displayBoard = createBoard();
	public static String guess = bld.toString();
	
	public static void main(String[] args) throws FileNotFoundException{
		//startup sequence
		System.out.println("Welcome to my word search");
		printBoard();
		y = getCol();
		x = getRow();
		updateGuess();
		updateDisplay();
		printBoard();
		//game loop
		while(gameOn){
			updateDisplay();
			printBoard();
			System.out.println("Letters so far: " + guess);
			System.out.println("Cardinal Directions: a, w, d, x");
			System.out.println("Diagonal directions: q, e, c, z");
			System.out.println(PROMPT);
			move();
		}
		//check to see if its contained within set of shakespeare names
		if(checkGuess()){
			System.out.println("Yes! " + guess + " is a Shakespeare name");	
		}
		else System.out.println("No! " + guess + " is not a Shakespeare name");
	}
	
	private static char getChar() {
		
        if (console.hasNextLine()) {
            String line = console.nextLine().toUpperCase();
            return line.charAt(0);
        }
        
        return '?';
    }
    
    private static int getCol() {
        System.out.println("Choose your starting column");
      
        char letter = 'Z';
        boolean inRange = false;
        
        while (console.hasNextLine() && !inRange) {
            letter = Character.toUpperCase(getChar());
            System.out.println(letter);
            System.out.println("You typed " + (char)letter);
            if (letter >= 'A' && letter <='F') {
                inRange = true;
            	break;
        	} else  {
                System.out.println("Letter not in my arbitrary range, i.e. " 
                	+ 'A' + " to "+  "D \ntry again...");
                System.out.print(PROMPT);
            }
        }
        return letter-'A';
    }   
	
	public static int getRow(){
		System.out.println("Choose your starting row");
		boolean inRange = false;
		int row = 100;
		
		while(console.hasNextInt() && !inRange){
			row = console.nextInt();
			if(row >= 0 && row < BOARD.length){
				return row;	
			} else {
				System.out.println("Out of range: guess again"); 
			}
		}
		return -1;	
	}
	
	public static char[][] createBoard() {
		
		//create new map of correct dimensions
		char[][] map = new char[NUMROW][NUMCOL];
		
		//set word search indexes to corresponding letter in SOURCE
		for(int r = 0; r < map.length; r++){
			for(int c = 0; c < map[0].length; c++){
				map[r][c] = SOURCE.charAt(map.length * r + c);
			}
		}
		return map; 
		
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
		bld.append(BOARD[x][y]);
		guess = bld.toString();
	}
	
	public static boolean checkMove(char m){
		for(int i = 0; i < KEYS.length; i++){
			if(KEYS[i] == m){
				if(x + X_DIR[i] < 0 || x + X_DIR[i] > BOARD.length) return false;
				if(y + Y_DIR[i] < 0 || y + Y_DIR[i] > BOARD.length) return false;
			}
		}
		return true;
	}
	
	public static boolean checkGuess(){
		//loop through array of shakespeare names and return true if you find one that matches guess
		for(int i = 0; i < NAMES.length; i++){
			if (NAMES[i].equals(guess)) return true;
		}
		return false;
	}
	
	public static boolean move(){
		//for some reason it crashes if I dont have this line but it makes it so that i have to enter your move twice for it to go through
		console.nextLine();
		
		char m = 'z';
		m = getChar();
		boolean validMove = checkMove(m);
		
		//check to see if you should end the game
		if(m == '$'){
			gameOn = false;
			return false;
		}
		
		//find char in move list and move x and y corresponding values
		for(int i = 0; i < KEYS.length; i++){
			if(KEYS[i] == Character.toLowerCase(m)){
				x += X_DIR[i];
				y += Y_DIR[i];
				updateGuess();
				return true;
			}
		}
		return false;
	}
	
}