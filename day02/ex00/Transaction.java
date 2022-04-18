
public class Transaction {
	private static final int EXIT_ERROR = -1;
	public static enum category {DEBIT, CREDIT};

	private int			Identifier;
	private User		Recipient;
	private User		Sender;
	private category	Category;
	private int			Amount;

	public Transaction(User recipient, User sender, int amount) {
		Amount = amount;
		if (sender.getBalance() + amount < 0) {
			System.out.println("Not enough balance for transaction");
			return ;
		}
		Sender = sender;
		Recipient = recipient;
		if (amount < 0) {
			Category = category.DEBIT;
		}
		else {
			Category = category.CREDIT;
		}
	}

	public int getId() {
		return Identifier;
	}

	public User getRecipient() {
		return Recipient;
	}

	public User getSender() {
		return Sender;
	}

	public category getCategory() {
		return Category;
	}

	public int getAmout() {
		return Amount;
	}



	private static void exitError(String msg) {
		System.err.println(msg);
		System.exit(EXIT_ERROR);
	}
}
