public class Stack {
    public class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public class Stk {
        Node head = null;

        Stk(int[] arr) {
            int n = arr.length;
            if (n == 0) {
                return;
            } else if (n == 1) {
                head = new Node(arr[0]);
            } else {
                head = new Node(arr[0]);
                Node current = head;
                Node prev = null;
                for (int i = 1; i < n; i++) {
                    current.next = new Node(arr[i]);
                    current.next.prev = current;
                    prev = current;
                    current = current.next;
                }
            }
        }

        public void print_stk() {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println();
        }

        public void add(int val) {
            Node nd = new Node(val);
            if (head == null) {
                head = nd;
            } else {
                Node curr = head;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = nd;
                nd.prev = curr;
            }
        }

        public void remove() {
            Node curr = head;
            if (head == null) {
                System.out.println("Empty Stack");
            } else {
                while (curr.next != null) {
                    curr = curr.next;
                }
                if (curr.prev == null) {
                    head = null;
                } else {
                    curr.prev.next = null;
                }
                System.out.println("Data removed: " + curr.data);
            }
        }
    }

    public static void main(String args[]) {
        int[] arr = { 1, 2, 3, 4, 5 };
        Stk data = new Stack().new Stk(arr);
        data.print_stk();
        data.add(10);
        data.print_stk();
        data.remove();
        data.print_stk();
    }
}
