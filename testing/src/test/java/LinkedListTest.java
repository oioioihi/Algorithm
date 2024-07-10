import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    void LinkedList() {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;

        System.out.println("Linked List : ");
        System.out.println(node1.data);
        System.out.println(node1.next.data);
        System.out.println(node1.next.next.data);
    }

    static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static class LinkedList {
        private Node head;
        private int count;

        public LinkedList() {
            this.head = null;
            this.count = 0;
        }

        public void insertAt(int index, int data) {
            if (index > this.count || index < 0) {
                throw new IllegalArgumentException();
            }

            Node newNode = new Node(data);

            if (index == 0) {
                newNode.next = this.head;
                this.head = newNode;
            } else {

                Node currentNode = this.head;
                for (int i = 0; i < index - 1; i++) {
                    currentNode = currentNode.next;
                }

                newNode.next = currentNode.next;
                currentNode.next = newNode;
            }
            this.count++;
        }
    }


}
