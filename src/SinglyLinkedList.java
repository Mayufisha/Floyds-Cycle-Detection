import java.util.HashSet;
import java.util.Set;

public class SinglyLinkedList {
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
    public boolean hasCycle() {
        Node tortoise = head;
        Node hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            if (tortoise == hare) {
                return true;
            }
        }
        return false;
    }
    public void createCycle(int pos) {
        if (pos < 0) return;

        Node tail = head, cycleStart = null;
        int idx = 0;

        while (tail.next != null) {
            if (idx == pos) {
                cycleStart = tail;
            }
            tail = tail.next;
            idx++;
        }
        if (cycleStart != null) {
            tail.next = cycleStart;
        }
    }
    public Node getCycleStart() {
        Node tortoise = head;
        Node hare = head;

        // First, detect cycle
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            if (tortoise == hare) {
                tortoise = head;
                while (tortoise != hare) {
                    tortoise = tortoise.next;
                    hare = hare.next;
                }
                return tortoise;
            }
        }
        return null;
    }
    public void printGraphList() {
        Set<Node> visited = new HashSet<>();
        Node current = head;

        while (current != null) {
            System.out.print(current.value);

            if (visited.contains(current.next)) {
                System.out.print(" -> " + current.next.value + " (cycle starts here)");
                break;
            }

            visited.add(current);
            current = current.next;

            if (current != null) System.out.print(" -> ");
        }
        System.out.println();
    }

}
