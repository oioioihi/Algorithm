import org.junit.jupiter.api.Test;

public class MyDoubleLinkedList {

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
        private Node prev;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {

            return data;
        }

        public Node getNext() {
            return next;
        }
    }

    static class LinkedList {
        private Node head;
        private Node tail;
        private int count;

        public LinkedList() {
            this.head = null;
            this.tail = null;
            this.count = 0;
        }

        public Node getHead() {
            return head;
        }

        public int getCount() {
            return count;
        }

        public void insertAt(int index, int data) {
            if (index > this.count || index < 0) {
                throw new IllegalArgumentException();
            }

            Node newNode = new Node(data);

            if (index == 0) { // head에 삽입하는 경우
                newNode.next = this.head;
                if (this.head != null) {
                    this.head.prev = newNode;
                }
                this.head = newNode;
            } else if (index == this.count) { // tail에 삽입하는 경우

                newNode.next = null;
                newNode.prev = this.tail;
                this.tail.next = newNode;
                this.tail = newNode;
            } else { // 그외 위치에 삽입하는 경우

                Node currentNode = this.head;
                for (int i = 0; i < index - 1; i++) {
                    currentNode = currentNode.next;
                }

                newNode.next = currentNode.next;
                newNode.prev = currentNode;
                currentNode.next = newNode;
                newNode.next.prev = newNode;
            }

            if (newNode.next == null) {
                this.tail = newNode;
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
                if (this.head.next == null) { // 데이터가 1개일 때
                    this.head = null;
                    this.tail = null;
                } else { // 데이터가 2개 이상일 때
                    this.head = this.head.next;
                    this.head.prev = null;
                }
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
