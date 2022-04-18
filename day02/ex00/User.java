
public class User {

	private int	Identifier;
	private String	Name;
	private int		Balance;

	public User(String name, int startBalance) {
		Name = name;
		if (startBalance < 0) {
			Balance = 0;
		}
		else {
			Balance = startBalance;
		}
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

}
