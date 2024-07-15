package week1.dsa;

public class exercise1 {
    class AVLTree {
        private class Node {
            int key, height;
            Node left, right;

            Node(int d) {
                key = d;
                height = 1;
            }
        }

        private Node root;

        private int height(Node N) {
            if (N == null)
                return 0;
            return N.height;
        }

        private int max(int a, int b) {
            return (a > b) ? a : b;
        }

        private Node rightRotate(Node y) {
            Node x = y.left;
            Node T2 = x.right;

            x.right = y;
            y.left = T2;

            y.height = max(height(y.left), height(y.right)) + 1;
            x.height = max(height(x.left), height(x.right)) + 1;

            return x;
        }

        private Node leftRotate(Node x) {
            Node y = x.right;
            Node T2 = y.left;

            y.left = x;
            x.right = T2;

            x.height = max(height(x.left), height(x.right)) + 1;
            y.height = max(height(y.left), height(y.right)) + 1;

            return y;
        }

        private int getBalance(Node N) {
            if (N == null)
                return 0;
            return height(N.left) - height(N.right);
        }

        public void insert(int key) {
            root = insertRec(root, key);
        }

        private Node insertRec(Node node, int key) {
            if (node == null)
                return (new Node(key));

            if (key < node.key)
                node.left = insertRec(node.left, key);
            else if (key > node.key)
                node.right = insertRec(node.right, key);
            else
                return node;

            node.height = 1 + max(height(node.left), height(node.right));

            int balance = getBalance(node);

            if (balance > 1 && key < node.left.key)
                return rightRotate(node);

            if (balance < -1 && key > node.right.key)
                return leftRotate(node);

            if (balance > 1 && key > node.left.key) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }

            if (balance < -1 && key < node.right.key) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

            return node;
        }

        public void delete(int key) {
            root = deleteRec(root, key);
        }

        private Node deleteRec(Node root, int key) {
            if (root == null)
                return root;

            if (key < root.key)
                root.left = deleteRec(root.left, key);
            else if (key > root.key)
                root.right = deleteRec(root.right, key);
            else {
                if ((root.left == null) || (root.right == null)) {
                    Node temp = null;
                    if (temp == root.left)
                        temp = root.right;
                    else
                        temp = root.left;

                    if (temp == null) {
                        temp = root;
                        root = null;
                    } else
                        root = temp;
                } else {
                    Node temp = minValueNode(root.right);

                    root.key = temp.key;

                    root.right = deleteRec(root.right, temp.key);
                }
            }

            if (root == null)
                return root;

            root.height = max(height(root.left), height(root.right)) + 1;

            int balance = getBalance(root);

            if (balance > 1 && getBalance(root.left) >= 0)
                return rightRotate(root);

            if (balance > 1 && getBalance(root.left) < 0) {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }

            if (balance < -1 && getBalance(root.right) <= 0)
                return leftRotate(root);

            if (balance < -1 && getBalance(root.right) > 0) {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }

            return root;
        }

        private Node minValueNode(Node node) {
            Node current = node;

            while (current.left != null)
                current = current.left;

            return current;
        }

        public boolean search(int key) {
            return searchRec(root, key);
        }

        private boolean searchRec(Node root, int key) {
            if (root == null)
                return false;

            if (root.key == key)
                return true;

            return root.key > key ? searchRec(root.left, key) : searchRec(root.right, key);
        }
    }

}
