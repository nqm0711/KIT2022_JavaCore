package Basic.Day5;

class Node {
    int key;
    Node left, right;

    Node(int x) {
        key = x;
        left = right = null;
    }
}

class BSTree {
    Node root;

    public BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void insert(int x) {
        if (isEmpty()) {
            root = new Node(x);
            return;
        }
        Node findNode = root, parent = null;
        while (findNode != null) {
            if (x == findNode.key) {
                System.out.println(x + " đã có trong cây");
                return;
            }
            parent = findNode;
            if (findNode.key > x) {
                findNode = findNode.left;
            } else findNode = findNode.right;
        }
        if (parent.key > x) {
            parent.left = new Node(x);
        } else parent.right = new Node(x);
    }

    Node findNode(int x) {
        Node nd = root;
        while (nd != null && nd.key != x)
            if (nd.key > x)
                nd = nd.left;
            else nd = nd.right;
        return nd; // nd == null khi không tìm thấy x hoặc root = null
    }

    //////////////////////DELETE KHÔNG ĐỆ QUY /////////////////////////////
    boolean delete(int x) {
        Node nX = root, parentX = null;
        while (nX.key != x && nX != null) {
            parentX = nX;
            if (nX.key > x)
                nX = nX.left;
            else
                nX = nX.right;
        }
        if (nX == null) return false;
        if (nX.left == null || nX.right == null) {
            if (parentX == null){

                if (root.left != null) root = root.left;
                root= root.right;
            } else {
                if (parentX.key < x) {
                    parentX.right = nX.right;
                    if (nX.left != null) parentX.right = nX.left;
                } else {
                    parentX.left = nX.right;
                    if (nX.left != null) parentX.left = nX.left;
                }
            }
        } else {// case 2 con != null
            Node rootOfRight = nX.right, leftMost = nX.right, parent = null;
            while (leftMost.left!= null) {
                parent = leftMost;
                leftMost = leftMost.left;
            }
            nX.key = leftMost.key;
            if (parent == null){
                nX.right = leftMost.right;
            }else {
                parent.left = leftMost.right;
            }
        }
        return true;
    }
    //////////////////////DELETE KHÔNG ĐỆ QUY /////////////////////////////

    //////////////////////////////////////////////////////////////////////
    void printTree(Node node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        System.out.print(node.key + " ");
        printTree(node.right);
    }
}

public class BSTDemo {
    public static void main(String[] args) {
        BSTree bst = new BSTree();
        bst.insert(8);
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.insert(7);
        bst.printTree(bst.root);
    }
}