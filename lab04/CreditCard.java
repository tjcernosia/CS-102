import java.util.Calendar;
import java.util.Random;


public class CreditCard{
	
	//public static 
	
	public static final int DEFAULT_LIMIT = 500;
	
	public static int serialCount = 3000;

	private String accountName;
	private int accountNumber;
	private int expirationMonth;
	private int expirationYear;
	private int cvv; 
	private double creditLimit;
	private double balance;	
	
    //use me for generating random numbers!
    private static final Random rand = new Random();
    
    // ******** CONSTRUCTORS ********
    
    public CreditCard(String accountName, int expirationMonth, int expirationYear, double creditLimit){
    	this.accountName = accountName;
    	this.creditLimit = creditLimit;
    	this.expirationMonth = expirationMonth;
    	this.expirationYear = expirationYear;
    	this.serialCount++;
    	this.accountNumber = this.serialCount;
    	this.cvv = rand.nextInt(900) + 100;
    	
    	if(!(0 < this.expirationMonth && this.expirationMonth <= 12) || expirationYear != getTodaysYear() + 10){
    		this.expirationMonth = getTodaysMonth();
    		this.expirationYear = getTodaysYear() + 5; 
    	}

    	if(creditLimit <= 0){
    		this.creditLimit = DEFAULT_LIMIT;
    	}
    }
    
    public CreditCard(String accountName, int expirationMonth, int expirationYear){
    	this(accountName, expirationMonth, expirationYear, DEFAULT_LIMIT);
    }
    
    public CreditCard(String accountName){
    	this(accountName, getTodaysMonth(), getTodaysYear() + 5, DEFAULT_LIMIT);
    }
    
    // ******** END CONSTRUCTORS ********
    
    // ******** GETTERS SETTERS ********
    
    public String getName(){
    	return accountName;
    }	
    
    public double getCreditLimit(){
    	return creditLimit;	
    }
    
    public int getExpireMonth(){
    	return expirationMonth;
    }
    
    public int getExpireYear(){
    	return expirationYear;
    }
    
    public double getBalance(){
    	return balance;	
    }
    
    public void extendExpiration(int months){
    	if(0 < months){
    		expirationMonth += months % 12;
    		expirationYear += months / 12;
    	}
    }
    
    public void extendExpiration(int months, int years){
    	if(0 < months && 0 < years){
    		expirationMonth += months % 12;
    		expirationYear += years + months / 12;
    	}
    }
    
    public static int lookupCVV(CreditCard card, String name, int accountNumber){
    	if(name.equals(card.accountName) && accountNumber == card.accountNumber){
    		return card.cvv;
    	}
    	return -1;
    }
    
    public static void wipeCards(CreditCard c1, CreditCard c2){
    	int temp = c1.accountNumber;
    	c1.accountName = "Merged with #" + c2.accountNumber;
    	c2.accountName = "Merged with #" + temp;
    	
    	c1.balance = -1;
    	c2.balance = -1;
    	
    	c1.accountNumber = -1;
    	c2.accountNumber = -1;
    	
    	c1.cvv = -1;
    	c2.cvv = -1;
    	
    	c1.expirationMonth = -1;
    	c2.expirationMonth = -1;
    	c1.expirationYear = -1;
    	c2.expirationYear = -1;
    	
    	c1.creditLimit = -1;
    	c2.creditLimit = -1;
    	
    	c1.accountNumber = -1;
    	c2.accountNumber = -1;
    	
    	c1.balance = -1;
    	c2.balance = -1;
    }
    
    // ******** END GETTERS SETTERS ********
    
    // ******** PAYMENT METHODS ********
    
    public boolean makeCharge(double amount, int cvv){
    	if(balance + amount <= creditLimit && this.cvv == cvv && amount > 0 && checkExpired()){
    		balance += amount; 
    		return true;
    	}
    	return false;
    }
    
    public boolean makePayment(double amount){
    	if(amount > 0 && balance - amount > creditLimit * -1){
    		balance -= amount; 
    		return true;
    	}
    	return false;
    }
    
    
    // ******** END PAYMENT METHODS ********
    
    // ******** SPECIAL METHODS ********

    public String toString(){
    	return accountName
    		+ " (#" 
    		+ accountNumber 
    		+ "): Current Balance = $" 
    		+ balance + "/$" + creditLimit 
    		+ ", expires : " + expirationMonth 
    		+ "/" + expirationYear;
    }
    
    /*public boolean equals(Object card){
    	if(card instanceof CreditCard){
    		CreditCard r = (CreditCard)card;
    		return this.accountName.equals(r.accountName) 
    			&& this.accountNumber == r.accountNumber
    			&& this.expirationMonth == r.expirationMonth
    			&& this.expirationYear == r.expirationMonth
    			&& this.cvv == r.cvv
    			&& this.creditLimit == r.creditLimit
    			&& this.balance == r.balance;
    	}
    	return false;
    }*/
    
    // ******** END SPECIAL METHODS ********
    
    //returns true if card is expired
    public boolean checkExpired(){
    	return !(expirationYear >= getTodaysYear() || expirationMonth > getTodaysMonth());
    }
    
    public static CreditCard mergeCards(CreditCard c1, CreditCard c2){
    	// create new credit card with correct parameters
    	int newYear = c2.expirationYear;
    	int newMonth = c2.expirationMonth;
    	if(c1.expirationYear < c2.expirationYear){
    		newYear = c1.expirationYear;
    		newMonth = c1.expirationMonth;
    	}
    	
    	CreditCard r = new CreditCard(
    		new String(c1.accountName + " and " + c2.accountName),
    		newMonth,
    		newYear,
    		c1.creditLimit + c2.creditLimit	
    	);
    	
    	// destroy old cards
    	wipeCards(c1, c2);
    	return r;
    }

     //***   Try us!  See what these methods' returned values look like!  ****
     public static int getTodaysMonth(){
          Calendar currentDate = Calendar.getInstance();
          return currentDate.get(currentDate.MONTH) + 1;
     }

     public static int getTodaysYear(){
          Calendar currentDate = Calendar.getInstance();
          return currentDate.get(currentDate.YEAR);
     }
    //************************************************************************







}
