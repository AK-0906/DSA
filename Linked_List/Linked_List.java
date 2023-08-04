public class Linked_List {
    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public class LL {
        Node head = null;

        LL(int[] arr) {
            int n = arr.length;
            if (n == 0) {
                return;
            } else if (n == 1) {
                head = new Node(arr[0]);
            } else {
                head = new Node(arr[0]);
                Node current = head;
                for (int i = 1; i < n; i++) {
                    current.next = new Node(arr[i]);
                    current = current.next;
                }
            }
        }

        public void print_Ll() {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println();
        }

        public void add_last(int val) {
            Node nd = new Node(val);
            if (head == null) {
                head = nd;
            } else {
                Node curr = head;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = nd;
            }
        }
        public void add_first(int val){
            Node nd = new Node(val);
            if (head == null){
                head = nd;
            }
            else{
                Node temp = head;
                head = nd;
                head.next = temp;
            }
        }
    }

    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5};
        LL linkedList = new Linked_List().new LL(arr);
        linkedList.print_Ll();
        linkedList.add_last(10);
        linkedList.print_Ll();
        linkedList.add_first(8);
        linkedList.print_Ll();
    }
}
