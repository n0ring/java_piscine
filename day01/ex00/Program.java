public class Program {

	public static void main(String[] args) {
		System.out.println("John has transferred 500 to Mike");
		System.out.println("Correct transactions: ");
		User john = new User("John", 500);
		User mike = new User("Mike", 500);

		Transaction correctTr1 = new Transaction(john, mike, 500, Transaction.category.DEBIT);
		System.out.println(correctTr1);
		Transaction correctTr2 = new Transaction(mike, john, -500, Transaction.category.CREDIT);
		System.out.println(correctTr2);


		System.out.println("Incorrect transactions: ");
		Transaction wrongTr1 = new Transaction(john, mike, 50, Transaction.category.CREDIT);
		Transaction wrongTr2 = new Transaction(mike, john, -50, Transaction.category.DEBIT);
		Transaction wrongTr4 = new Transaction(mike, john, -600, Transaction.category.CREDIT);
		Transaction wrongTr5 = new Transaction(mike, john, 600, Transaction.category.DEBIT);
	}

}
