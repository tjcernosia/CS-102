/*
 Lab 03
 
 This client program uses Bank Account objects.
*/

public class BankAccountClient {
     
    //create a main method with test cases here!
    public static void main(String[] args){
    	// test: toString
    	BankAccount test1 = new BankAccount("Thomas Cernosia",1);
    	
    	System.out.println("Test: toString() function:");
    	System.out.println("Name: Thomas Cernosia  Min Bal: $1");
    	System.out.println(test1 + "\n\n");
    	
    	// test: name too short
    	BankAccount tooShort = new BankAccount("Al C");
    	
    	System.out.println("Test: name shorter than MIN_LENGTH");
    	System.out.println("Name: Al C");
    	System.out.println(tooShort + "\n\n");
    	
    	// test: only first name
    	BankAccount noSpace = new BankAccount("Thomas");
    	
    	System.out.println("Test: no last name");
    	System.out.println("Name: Thomas");
    	System.out.println(noSpace + "\n\n");
    	
    	// test: negative min balance
    	BankAccount negativeMin = new BankAccount("Thomas Cernosia", -5);
    	
    	System.out.println("Test: negative min balance");
    	System.out.println("Name: Thomas Cernosia  minBal: -$5");
    	System.out.println(negativeMin + "\n\n");
    	
    	// test: withdraw below min bal
    	BankAccount withdrawBad = new BankAccount("Thomas Cernosia");
    	
    	System.out.println("Test: withdraw below min balance");
    	System.out.println("Minimum Balance: " + withdrawBad.getMinBalance());
    	System.out.println("Account Before Withdraw: " + withdrawBad);
    	System.out.println("Withdrawal amount: $5");
    	System.out.println("Withdrawal: " + withdrawBad.withdraw(5));
    	System.out.println("Account After Withdraw: " + withdrawBad + "\n\n");
    	
    	// test: correct withdraw
    	BankAccount withdraw = new BankAccount("Thomas Cernosia");
    	withdraw.deposit(10);
    	
    	System.out.println("Test: correct withdrawal");
    	System.out.println("Account Before Withdraw: " + withdraw);
    	System.out.println("Withdrawal amount: $5");
    	System.out.println("Withdrawal: " + withdraw.withdraw(5));
    	System.out.println("Account After Withdraw: " + withdraw + "\n\n");
    	
    	// test: negative withdrawal
    	BankAccount withdrawNeg = new BankAccount("Thomas Cernosia");
    	withdraw.deposit(10);
    	
    	System.out.println("Test: negative withdrawal");
    	System.out.println("Account Before Withdraw: " + withdrawNeg);
    	System.out.println("Withdrawal amount: -$5");
    	System.out.println("Withdrawal: " + withdrawNeg.withdraw(-5));
    	System.out.println("Account After Withdraw: " + withdrawNeg + "\n\n");
    	
    	// test: negative deposit
    	BankAccount depositNeg = new BankAccount("Thomas Cernosia");
    	
    	System.out.println("Test: negative deposit");
    	System.out.println("Account Before deposit: " + depositNeg);
    	System.out.println("Deposit amount: -$5");
    	System.out.println("Withdrawal: " + depositNeg.deposit(-5));
    	System.out.println("Account After Deposit: " + depositNeg + "\n\n");
    	
    	// test: correct deposit
    	BankAccount deposit = new BankAccount("Thomas Cernosia");
    	
    	System.out.println("Test: correct deposit");
    	System.out.println("Account Before deposit: " + deposit);
    	System.out.println("Deposit amount: $20");
    	System.out.println("Withdrawal: " + deposit.deposit(20));
    	System.out.println("Account After Deposit: " + deposit + "\n\n");
    	
    	// test: correct transfer money
    	BankAccount send = new BankAccount("Thomas Cernosia");
    	BankAccount receive = new BankAccount("Prof. Fourquet");
    	
    	send.deposit(100);
    	
    	System.out.println("Test: correct money transfer");
    	System.out.println("Accounts before transfer: ");
    	System.out.println(send);
    	System.out.println(receive);
    	System.out.println("Transfer amount: $50");
    	System.out.println("Transfer: " + send.transferMoney(receive, 50));
    	System.out.println("Accounts after transfer: ");
    	System.out.println(send);
    	System.out.println(receive + "\n\n");
    	
    	// test: incorrect transfer money
    	BankAccount sendBad = new BankAccount("Thomas Cernosia");
    	BankAccount receiveBad = new BankAccount("Prof. Fourquet");
    	
    	sendBad.deposit(100);
    	
    	System.out.println("Test: broken money transfer (min bal)");
    	System.out.println("Accounts before transfer: ");
    	System.out.println(sendBad);
    	System.out.println(receiveBad);
    	System.out.println("Transfer amount: $100");
    	System.out.println("Transfer: " + sendBad.transferMoney(receiveBad, 100));
    	System.out.println("Accounts after transfer: ");
    	System.out.println(sendBad);
    	System.out.println(receiveBad);
    	
    }

}
