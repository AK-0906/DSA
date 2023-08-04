import java.time.chrono.HijrahEra;

public class Binary_Tree {
    public static class Node {
        int data;
        Node right;
        Node left;

        Node(int val) {
            this.data = val;
            this.right = null;
            this.left = null;
        }
    }

    public static class BT {
        static int idx = -1;

        public static Node buildTree(int arr[]) {
            idx++;
            if (arr[idx] == -1) {
                return null;
            }
            Node newNode = new Node(arr[idx]);
            newNode.left = buildTree(arr);
            newNode.right = buildTree(arr);
            return newNode;
        }

        public static void preorder(Node root) {
            if (root == null) {
                return;
            }
            else{
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
            }

        }

        public static int Height(Node root) {
            if (root == null) {
                return 0;
            } else {
                int height_left = Height(root.left);
                int height_right = Height(root.right);
                return (1 + Math.max(height_left, height_right));
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = BT.buildTree(arr);
        BT.preorder(root);
        System.out.println();
        int height = BT.Height(root);
        System.out.println(height);
    }
}
