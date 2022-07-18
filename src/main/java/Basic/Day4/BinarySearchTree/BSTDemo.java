package Basic.Day4.BinarySearchTree;

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

    void delete(int x) {
        if (isEmpty()) {
            System.out.println("Cây dữ liệu không có phần tử nào");
            return;
        }
        else {
            Node findNode = root, parent = root;
            while (x!= findNode.key) {
                parent = findNode;
                if (x < findNode.key) {
                    findNode = findNode.left;
                }
                if (x > findNode.key) {
                    findNode = findNode.right;
                }
            }
            if (x == findNode.key){
                if (findNode.left==null&&findNode.right==null){
                    findNode=null;
                }
                else if (findNode.left != null&&findNode.right!=null){
                    Node alternative = findNode.right;
                    while (alternative.left!=null){
                        alternative=alternative.left;
                    }
                    alternative=findNode.left;
                    if (parent.left == findNode)parent.left=alternative;
                    else parent.right=alternative;
                }

                else {
                    if (findNode.left==null){
                        findNode=findNode.right;
                    }
                    else findNode=findNode.left;
                }
            }
        }
    }

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
        bst.insert(9);
        bst.insert(4);
        bst.insert(13);
        bst.insert(1);
        bst.insert(8);
        bst.insert(2);
        bst.insert(16);
        bst.insert(17);
        bst.insert(3);
        bst.insert(10);
        bst.insert(18);
        bst.insert(14);

        bst.insert(19);
        bst.printTree(bst.root);
        bst.delete(10);
        System.out.println("\n");
        bst.printTree(bst.root);
    }
}