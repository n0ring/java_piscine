import java.util.UUID;

public class Transaction {
	public static enum category {DEBIT, CREDIT};

	private UUID		Identifier;
	private User		Recipient;
	private User		Sender;
	private category	Category;
	private int			Amount;

	public Transaction(User sender, User recipient, int amount, category transactionType) {
		if ( (transactionType == category.CREDIT && recipient.getBalance() + amount < 0) 
			|| (transactionType == category.DEBIT && sender.getBalance() - amount < 0)  ) {
			System.err.println("Not enough balance for transaction");
			return ;
		}
		if ((amount > 0 && transactionType == category.CREDIT)
		|| (amount < 0 && transactionType == category.DEBIT)  ) {
			System.err.println("Transaction type and amount incorrect");
			return ;
		}
		Identifier = UUID.randomUUID();
		Recipient = recipient;
		Sender = sender;
		Category = transactionType;
		Amount = amount;
	}

	public UUID getId() {
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

	@Override
	public String toString() {
		return "Transaction: { " +
							"ID: " + getId() +
							" Sender: " + getSender().toString() +
							" Recipient: " + getRecipient().toString() + 
							" Category: " + getCategory() + 
							" Amount: " + getAmout() + " }";
	}
}
