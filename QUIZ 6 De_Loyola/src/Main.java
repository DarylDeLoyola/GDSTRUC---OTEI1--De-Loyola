public class Main {
    public static void main(String[] args) {
        Binarytree binaryTree = new Binarytree();
        binaryTree.insert(25);
        binaryTree.insert(20);
        binaryTree.insert(15);
        binaryTree.insert(27);
        binaryTree.insert(30);
        binaryTree.insert(29);
        binaryTree.insert(26);
        binaryTree.insert(22);
        binaryTree.insert(32);

        System.out.println("Presenting Transverse In Order: ");
        binaryTree.traverseInOrder();
        System.out.println();

        //Get Minimum Value
        System.out.println("Presenting Minimum Node: ");
        System.out.println(binaryTree.GetMin());
        System.out.println();

        //Get Maximum Value
        System.out.println("Presenting Maximum Node: ");
        System.out.print(binaryTree.GetMax());
        System.out.println();

        //Descending In-Order Traversal
        System.out.println();
        System.out.println("Presenting Descending In-Order Traversal: ");
        binaryTree.traverseInOrderDescending();

        System.out.println();

        //Main Search Function
        int findIndex = 15;
        System.out.println("\nNode with value " + findIndex + " = " + binaryTree.get(findIndex));
    }
}