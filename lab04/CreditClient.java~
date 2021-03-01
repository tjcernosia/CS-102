

public class CreditClient{

	public static void main(String[] args){
		
		System.out.println("******** Constructor Tests ********");
		
		System.out.println("Test: only name");
		System.out.println("Parameters: (Thomas)");
		System.out.println(new CreditCard("Thomas") + "\n");
		
		System.out.println("Test: no limit");
		System.out.println("Parameters: (Thomas, 11, 2031)");
		System.out.println(new CreditCard("Thomas", 11, 2031) + "\n");
		
		System.out.println("Test: all parameters");
		System.out.println("Parameters: (Thomas, 11, 2031, $1000)");
		System.out.println(new CreditCard("Thomas", 11, 2031, 1000) + "\n");
		
		System.out.println("Test: invalid date (month)");
		System.out.println("Parameters: (Thomas, 13, 2031)");
		System.out.println(new CreditCard("Thomas", 13, 2031) + "\n");
		
		System.out.println("Test: invalid date (year)");
		System.out.println("Parameters: (Thomas, 11, 2057)");
		System.out.println(new CreditCard("Thomas", 11, 2057) + "\n");
		
		System.out.println("******** makeCharge(), makePayment(), lookupCVV() Tests ********");
		CreditCard card1 = new CreditCard("Thomas", 1023, 3123, 1000);
		System.out.println("Test: normal charge");
		System.out.println("Parameters: (Thomas, 1023, 3123, $1000)");
		System.out.print("Before charge ($500): ");
		System.out.println(card1);
		System.out.println("Charge: " + card1.makeCharge(500, CreditCard.lookupCVV(card1, "Thomas", 3006)));
		System.out.print("After charge: ");
		System.out.println(card1 + "\n");
		
		CreditCard card2 = new CreditCard("Thomas", 1023, 3123, 1000);
		System.out.println("Test: broken charge (negative amount)");
		System.out.println("Parameters: (Thomas, 1023, 3123, $1000)");
		System.out.print("Before charge ($-500): ");
		System.out.println(card2);
		System.out.println("Charge: " + card2.makeCharge(-500, CreditCard.lookupCVV(card2, "Thomas", 3007)));
		System.out.print("After charge: ");
		System.out.println(card2 + "\n");
		
		CreditCard card3 = new CreditCard("Thomas", 1023, 3123, 1000);
		System.out.println("Test: broken charge (incorrect cvv)");
		System.out.println("Parameters: (Thomas, 1023, 3123, $1000)");
		System.out.print("Before charge ($-500): ");
		System.out.println(card3);
		System.out.println("Charge: " + card3.makeCharge(-500, 100));
		System.out.print("After charge: ");
		System.out.println(card3 + "\n");
		
		CreditCard card4 = new CreditCard("Thomas", 1023, 3123, 1000);
		System.out.println("Test: broken charge (over credit limit)");
		System.out.println("Parameters: (Thomas, 1023, 3123, $1000)");
		System.out.print("Before charge ($1100): ");
		System.out.println(card4);
		System.out.println("Charge: " + card4.makeCharge(1100, 100));
		System.out.print("After charge: ");
		System.out.println(card4 + "\n");
		
		
	}
		
}