public class SingelyLinkedList {
    static class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(value);
        }
    }
}
