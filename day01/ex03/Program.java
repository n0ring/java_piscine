
public class Program {
	public static void main(String[] args) {
		TransactionsLinkedList trList = new TransactionsLinkedList();
		User jhon = new User("Jhonnn", 500);
		User mike = new User("Mikeee", 500);
		Transaction toDel = new Transaction(jhon, mike, -100, Transaction.category.CREDIT);
		trList.addTransaction(toDel);

		for (int i = 0; i < 5; i++) {
			trList.addTransaction(new Transaction(
				new User("John", 500),
				new User("Mike", 1000),
				-100, Transaction.category.CREDIT));
		}
		trList.showList();
		System.out.println("----------");
		trList.removeTransactionById(toDel.getId().toString());
		trList.showList();
	}
}