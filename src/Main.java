public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        for (int i = 1; i <= 7; i++) {
            list.add(i);
        }

        list.createCycle(3);
        list.printGraphList();

        System.out.println("Has cycle: " + list.hasCycle());

        SinglyLinkedList.Node cycleStart = list.getCycleStart();
        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.value);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}
