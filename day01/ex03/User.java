
public class User {

	private final	int						Identifier;
	private 		String					Name;
	private			int						Balance;
	private			TransactionsLinkedList	trList ;

	public User(String name, int startBalance) {
		Name = name;
		Identifier = UserIdsGenerator.getInstance().generateId();
		setBalance(startBalance);
		trList = new TransactionsLinkedList();
	}

	public int getId() {
		return Identifier;
	}

	public String getName() {
		return Name;
	}

	public int getBalance() {
		return Balance;
	}

	public void setBalance(int newBalance) {
		if (newBalance < 0) {
			Balance = 0;
			return ;
		}
		Balance = newBalance;
	}

	public void setName(String newName) {
		Name = newName;
	}

	public TransactionsLinkedList getListTransactions() {
		return trList;
	}

	@Override
	public String toString() {
		return ("User: { Id: " + this.Identifier + ". Name: "
			+ this.Name + ". Balance: " + this.Balance + " }");
	}

}
