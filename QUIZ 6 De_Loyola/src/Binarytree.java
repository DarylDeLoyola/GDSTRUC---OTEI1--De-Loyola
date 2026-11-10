public class Binarytree {
    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        }
        else {
            root.insert(value);
        }
    }

    public void traverseInOrder() {
        if (root != null)
            root.traverseInOrder();
    }

    public void traverseInOrderDescending() {
        if (root != null) {
            root.traverseInOrderDescending();
        }
    }

    public Node get(int value) {
        if (root != null)
            return root.get(value);

        return null;
    }

    public Node GetMin() {
        if (root == null) {
            return null;
        }

        return root.GetMin();
    }

    public Node GetMax() {
        if (root == null) {
            return null;
        }

        return root.GetMax();
    }
}