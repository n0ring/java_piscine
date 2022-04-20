public class Node {
    private Transaction value = null;
    private Node next = null;
    private Node prev = null;

    Node(Transaction node_value) {
        value = node_value;
    }
    @Override
    public String toString() {
        return value.toString();
    }

    public Transaction getValue() {
        return value;
    }
     
    public Node getNext() {
        return this.next;
    }

    public Node getPrev() {
        return this.prev;
    }

    public void setNext(Node n) {
        this.next = n;
    }

    public void setPrev(Node n) {
        this.prev = n;
    }

    public void setValue(Transaction tr) {
        this.value = tr;
    }
}
