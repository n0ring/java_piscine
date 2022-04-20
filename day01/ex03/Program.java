import java.util.UUID;

public class Program {
	public static void main(String[] args) {
		User		jhon = new User("Jhonnn", 500);
		User		mike = new User("Mikeee", 500);
		Transaction toDel = new Transaction(jhon, mike, -111,
								Transaction.category.CREDIT);
		
		jhon.getListTransactions().addTransaction(toDel);
		for (int i = 0; i < 1; i++) {
			jhon.getListTransactions().addTransaction(new Transaction(
				jhon,
				new User("Mike", 1000),
				-100, Transaction.category.CREDIT));
		}
		Transaction toDel2 = new Transaction(jhon, mike, -444, Transaction.category.CREDIT);
		jhon.getListTransactions().addTransaction(toDel2);
		Transaction[] arr = jhon.getListTransactions().toArray();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("----------");
		jhon.getListTransactions().removeTransactionById(toDel.getId());
		jhon.getListTransactions().removeTransactionById(toDel2.getId());
		arr = jhon.getListTransactions().toArray();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		try {
			arr = mike.getListTransactions().toArray();
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			jhon.getListTransactions().removeTransactionById(UUID.randomUUID());
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			mike.getListTransactions().removeTransactionById(UUID.randomUUID());
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}