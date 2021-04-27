public class Main {
    public static void main(String[] args) {
        // Example
        Node node = new Node(4);
        node.appendToEnd(5);
        node.appendToEnd(6);
        node.appendToEnd(7);
        // End of Example

        // print nodes
        System.out.print("Print Nodes: ");
        node.printNodes();

        // print node length
        System.out.println("\nLength: " + node.length(node));
    }
}
