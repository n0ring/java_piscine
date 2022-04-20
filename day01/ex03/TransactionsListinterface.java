import java.util.UUID;

public interface TransactionsListinterface {
	void addTransaction(Transaction newTransaction);
	void removeTransactionById(UUID id) throws TransactionNotFoundException;
	Transaction[] toArray() throws TransactionListEmptyException;
}
