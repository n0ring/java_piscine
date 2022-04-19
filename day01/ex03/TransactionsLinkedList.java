public class TransactionsLinkedList implements TransactionsListinterface {
	private Node list;

	@Override
	public void addTransaction(Transaction newTransaction) {
		Node newNode    = new Node(newTransaction);
		Node lastNode;
		if (this.list == null) {
			list = newNode;
			return ;
		}
		if (this.list.next == null) {
			list.next = newNode;
			list.prev = newNode;
			newNode.next = list;
			newNode.prev = list;
			return;
		}
		lastNode = list.prev;
		lastNode.next = newNode;
		newNode.prev = lastNode;
		newNode.next = list;
		list.prev = newNode;
	}

	@Override
	public void removeTransactionById(String id) {
		Node nodeToRemove = this.findById(id);
		Node nodePrev;
		Node nodeNext;
		if (nodeToRemove == null) {
			System.out.println("no node with id " + id);
			return ;
		}
		nodeNext = nodeToRemove.next;
		nodePrev = nodeToRemove.prev;
		nodePrev.next = nodeNext;
		nodeNext.prev = nodePrev;
		if (nodeToRemove == list) {
			list = nodeNext;
		}
	}

	public void showList() {
		Node tmp;
		for (tmp = list; tmp.next != list; tmp = tmp.next) {
			System.out.println(tmp);
		}
		System.out.println(tmp);
	}

	private Node findById(String id) {
		Node tmp = list;
		do {
			if (tmp.value.getId().toString().equals(id)) {
				return tmp;
			}
			tmp = tmp.next;
		} while (tmp != list);

		return null;
	}

}
