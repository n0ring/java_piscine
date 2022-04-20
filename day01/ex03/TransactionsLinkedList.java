import java.util.UUID;

public class TransactionsLinkedList implements TransactionsListinterface {
	private Node	list;
	private	int		length = 0;

	@Override
	public void addTransaction(Transaction newTransaction) {
		Node newNode    = new Node(newTransaction);
		Node lastNode;
		length++;
		if (this.list == null) {
			list = newNode;
			return ;
		}
		if (this.list.getNext() == null) {
			list.setNext(newNode);
			list.setPrev(newNode);
			newNode.setNext(list);
			newNode.setPrev(list);
			return;
		}
		lastNode = list.getPrev();
		lastNode.setNext(newNode);
		newNode.setPrev(lastNode);
		newNode.setNext(list);
		list.setPrev(newNode);
	}

	@Override
	public void removeTransactionById(UUID id) throws TransactionNotFoundException {
		Node nodeToRemove = this.findById(id);
		Node nodePrev;
		Node nodeNext;
		if (nodeToRemove == null) {
			throw new TransactionNotFoundException(
				"Attempt to remove a transaction with non-existent ID");
		}
		nodeNext = nodeToRemove.getNext();
		nodePrev = nodeToRemove.getPrev();
		nodePrev.setNext(nodeNext);
		nodeNext.setPrev(nodePrev);
		if (nodeToRemove == list) {
			list = nodeNext;
		}
		nodeToRemove.setNext(null);
		nodeToRemove.setPrev(null);
		nodeToRemove.setValue(null);
		this.length--;
	}

	@Override
	public Transaction[] toArray() throws TransactionListEmptyException {
		Transaction[]	arr = new Transaction[this.length];
		Node			tmp = this.list;

		if (this.length == 0) {
			throw new TransactionListEmptyException("Transaction list is empty");
		}
		for (int i = 0; i < this.length; i++) {
			arr[i] = tmp.getValue();
			tmp = tmp.getNext();
		}
		return arr;
	}

	private Node findById(UUID id) throws TransactionListEmptyException {
		if (this.list == null) {
			throw new TransactionListEmptyException("Transaction list is empty");
		}
		Node tmp = this.list;
		for (int i = 0; i < this.length; i++) {
			if (tmp.getValue().getId().equals(id)) {
				return tmp;
			}
			tmp = tmp.getNext();
		}
		return null;
	}

}
