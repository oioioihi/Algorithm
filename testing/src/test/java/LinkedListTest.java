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

    @Test
    void LinkedList_Insert() {

        LinkedList linkedList = new LinkedList();
        linkedList.insertAt(0, 0);
        linkedList.insertAt(1, 1);
        linkedList.insertAt(2, 2);
        linkedList.insertAt(3, 3);
        linkedList.insertAt(4, 4);
        linkedList.insertLast(5);
        linkedList.printAll();

        System.out.println(" Clear ====================");
        linkedList.clear();
        linkedList.printAll();
    }

    @Test
    void LinkedList_delete() {

        LinkedList linkedList = new LinkedList();
        linkedList.insertAt(0, 0);
        linkedList.insertAt(1, 1);
        linkedList.insertAt(2, 2);
        linkedList.insertAt(3, 3);
        linkedList.insertAt(4, 4);
        linkedList.deleteAt(3);
        linkedList.printAll();

    }

    @Test
    void LinkedList_getNodeAt() {

        LinkedList linkedList = new LinkedList();
        linkedList.insertAt(0, 0);
        linkedList.insertAt(1, 1);
        linkedList.insertAt(2, 2);
        linkedList.insertAt(3, 3);
        linkedList.insertAt(4, 4);
        Node node = linkedList.getNodeAt(5);
        System.out.println(node.data);

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

        public void printAll() {
            Node currentNode = this.head;
            while (currentNode != null) {
                System.out.println(currentNode.data);
                currentNode = currentNode.next;
            }
        }

        public void clear() {
            this.head = null;
            this.count = 0;
        }

        public void insertLast(int data) {
            insertAt(this.count, data);
        }

        public Node deleteAt(int index) {
            if (index > this.count || index < 0) {
                throw new IllegalArgumentException();
            }

            Node currentNode = this.head;

            if (index == 0) {
                Node deleteNode = this.head;
                this.head = deleteNode.next;
                this.count--;
                return deleteNode;
            } else {
                for (int i = 0; i < index - 1; i++) {
                    currentNode = currentNode.next;
                }
                Node deleteNode = currentNode.next;
                currentNode.next = deleteNode.next;
                this.count--;
                return deleteNode;
            }
        }

        public Node deleteLast() {
            return deleteAt(this.count - 1);
        }

        public Node getNodeAt(int index) {
            if (index > this.count || index < 0) {
                throw new IllegalArgumentException();
            }
            Node currentNode = this.head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            return currentNode;
        }
    }


}
