public class Tries {
    public static class Node {
        Node[] child = new Node[26];
        boolean EOW = false;

        public Node() {
            for (int i = 0; i < 26; i++) {
                child[i] = null;
            }
        }
    }

    public static class trie {
        Node head;

        public trie() {
            head = new Node();
        }

        public void add(String word) {
            Node curr = head;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                int idx = word.charAt(i) - 'a';
                if (curr.child[idx] == null) {
                    curr.child[idx] = new Node();
                }
                curr = curr.child[idx];
            }
            curr.EOW = true;
        }

        public boolean search(String word) {
            Node curr = head;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                int idx = word.charAt(i) - 'a';
                if (curr.child[idx] == null) {
                    return false;
                }
                curr = curr.child[idx];
            }
            return curr.EOW;
        }
    }

    public static void main(String args[]) {
        String word[] = {"ajit", "kumar", "chhotu", "pandit"};
        trie Name = new trie();
        for (int i=0; i<word.length; i++){
        Name.add(word[i]);
        }
        System.out.println(Name.search("ajit")); 
        System.out.println(Name.search("monu")); 
        System.out.println(Name.search("chhotu")); 
        System.out.println(Name.search("random")); 
        System.out.println(Name.search("kumar")); 
    }
}
