
public class User {
	private static int userIds;

	private int		Identifier;
	private String	Name;
	private int		Balance;

	public User(String name, int startBalance) {
		Name = name;
		userIds++;
		Identifier = userIds;
		setBalance(startBalance);
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

	@Override
	public String toString() {
		return ("User: { Id: " + this.Identifier + ". Name: "
			+ this.Name + ". Balance: " + this.Balance + " }");
	}

}
