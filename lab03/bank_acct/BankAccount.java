// Each BankAccount object represents one user's account
// information including name and balance of money.

public class BankAccount {

	 public static final String DEFAULT_NAME = "DEFAULT NAME";
	 public static final int MIN_BALANCE = 5;
	 public static final int MIN_LENGTH = 5;
	 
     private String name;
     private double balance;
     private int minBalance;
     
     public BankAccount(){
     	 this(DEFAULT_NAME, MIN_BALANCE);
     }

     public BankAccount(String name){
     	 this(name, MIN_BALANCE);
     }
     
     public BankAccount(String name, int minBalance){
     	 //by default sets instance variable equal to argument
     	 this.name = name;
     	 //if name is too short or doesn't contain first and last name, overrides with default name
     	 if (name.length() < MIN_LENGTH || !name.contains(" ")){
     	 	 this.name = DEFAULT_NAME;
     	 }
     	 this.minBalance = minBalance;
     	 if (minBalance < 0) this.minBalance = 5;
     }

     public int getMinBalance(){
     	return minBalance;	 
     }

     public boolean deposit(double amount) {
     	  // if you're attempting to deposite "negative money" or no money at all balance isn't updated
          if (amount <= 0) return false;
          balance += amount;
          return true;
     }



     public boolean withdraw(double amount) {
     	  if (balance - amount >= minBalance && amount > 0){
     	  	  balance -= amount;
     	  	  return true;
          }
          return false;
     }



     public double getBalance(){
       return balance;
     }

     public String getName(){
       return name;
     }
     
     public String toString(){
     	 return (name + ", Balance: $" + balance + ", Min Bal: $" + minBalance);  
     }
     
     public boolean transferMoney(BankAccount acc, int amount){
     	 //if we can withdraw amount from our account, we can complete the transfer
     	 if (withdraw(amount)){
     	 	 acc.deposit(amount);
     	 	 return true;
     	 }
     	 //if withdraw fails, nothing is updated and balance, acc.balance arent updated
     	 return false;
     }

}
