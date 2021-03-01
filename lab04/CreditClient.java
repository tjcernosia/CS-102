

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
		System.out.print("Before charge ($500): ");
		System.out.println(card3);
		System.out.println("Charge: " + card3.makeCharge(500, 100));
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
		
		CreditCard card5 = new CreditCard("Thomas", 11, 2031);
		System.out.println("Test: broken payment (negative amount)");
		System.out.print("Before payment: ");
		System.out.println(card5);
		System.out.println("Payment parameters: (-500)");
		System.out.println("Payment: " + card5.makePayment(-500));
		System.out.print("After payment: ");
		System.out.println(card5 + "\n");
		
		CreditCard card6 = new CreditCard("Thomas", 11, 2031);
		System.out.println("Test: broken payment (credit limit)");
		System.out.print("Before payment: ");
		System.out.println(card6);
		System.out.println("Payment parameters: (600)");
		System.out.println("Payment: " + card6.makePayment(600));
		System.out.print("After payment: ");
		System.out.println(card6 + "\n");
		
		CreditCard card7 = new CreditCard("Thomas", 11, 2031);
		System.out.println("Test: correct payment");
		System.out.print("Before payment: ");
		System.out.println(card7);
		System.out.println("Payment parameters: (300)");
		System.out.println("Payment: " + card7.makePayment(300));
		System.out.print("After payment: ");
		System.out.println(card7 + "\n");
		
		CreditCard card8 = new CreditCard("Thomas");
		System.out.println("Test: lookupCVV information doesn't match");
		System.out.println(card8);
		System.out.println("lookupCVV() parameters: card8, thomas, 3013");
		System.out.println("lookupCVV: " + card8.lookupCVV(card8, "thomas", 3013) + "\n");
		
		CreditCard card9 = new CreditCard("Thomas");
		System.out.println("Test: correct lookupCVV");
		System.out.println(card9);
		System.out.println("lookupCVV() parameters: card9, Thomas, 3014");
		System.out.println("lookupCVV: " + card9.lookupCVV(card9, "Thomas", 3014) + "\n");
		
		
		System.out.println("******** extendExpiration() Test ********");
		
		
		CreditCard card10 = new CreditCard("Thomas");
		System.out.println("Test: broken parameter (-5 months)");
		System.out.print("Before extension: ");
		System.out.println(card10);
		System.out.print("After extension: ");
		card10.extendExpiration(-5);
		System.out.println(card10 + "\n");
		
		CreditCard card11 = new CreditCard("Thomas");
		System.out.println("Test: correct extension (29 months)");
		System.out.print("Before extension: ");
		System.out.println(card11);
		System.out.print("After extension: ");
		card11.extendExpiration(29);
		System.out.println(card11 + "\n");
		
		
		System.out.println("******** mergeCards() Test ********");
		
		
		CreditCard card12 = new CreditCard("Thomas", 5, 2031);
		CreditCard card13 = new CreditCard("Joseph");
		System.out.println("Before merge: ");
		System.out.println(card12);
		System.out.println(card13);
		System.out.println("After merge: ");
		CreditCard card14 = card12.mergeCards(card12, card13);
		System.out.println(card12);
		System.out.println(card13);
		System.out.println(card14 + "\n");
		
	}
		
}