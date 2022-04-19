public class Node {
    public Transaction value = null;
    public Node next = null;
    public Node prev = null;

    Node(Transaction node_value) {
        value = node_value;
    }
    @Override
    public String toString() {
        return value.toString();
    }
}
