import org.junit.jupiter.api.Test;

public class MyStack {

    @Test
    void stackTest() {

        Stack stack = new Stack();

        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(" Push =============");
        stack.linkedList.printAll();

        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(" Pop =============");
        stack.linkedList.printAll();

        MyLinkedList.Node peek = stack.peek();
        System.out.println(peek.getData());

        boolean empty = stack.isEmpty();
        System.out.println("is Empty ? : " + empty);

    }

    static class Stack {

        MyLinkedList.LinkedList linkedList;

        public Stack() {
            this.linkedList = new MyLinkedList.LinkedList();
        }

        public void push(int data) {
            this.linkedList.insertAt(0, data);
        }

        public MyLinkedList.Node pop() {
            try {

                return this.linkedList.deleteAt(0);
            } catch (Exception e) {
                return null;
            }
        }

        public MyLinkedList.Node peek() {
            return this.linkedList.getNodeAt(0);
        }

        public boolean isEmpty() {
            return this.linkedList.getCount() == 0;
        }
    }
}
