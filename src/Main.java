public class Main {

    private static final int[] factoryPoint = {3, 7};

    private static final int[][] customerPoints = {{1, 4}, {1, 10},
            {2, 1}, {5, 2}, {6, 5}, {8, 4}, {8, 9}, {9, 2}};

    private static final int MULTIPLIER = 1000;

    public static void main(String[] args) {

        // Each node represents a customer.
        // Node(data) indicates the distance of the customer from the factory.
        Node node = new Node(distanceFromFactory(customerPoints[0][0], customerPoints[0][1]));

        // adding customers to the linked list
        for (int i = 1; i < customerPoints.length; i++) {
            node.appendToEnd(distanceFromFactory(customerPoints[i][0], customerPoints[i][1]));
        }

        // print nodes
        System.out.print("Print Nodes: ");
        node.printNodes();

        // print node length
        System.out.println("\nLength: " + node.length(node));

        // print sum of nodes
        System.out.println("Sum Of Nodes: " + node.sumOfNodes());

        // delete nodes and print new node
        Node temp = node.deleteNode(node, 1);
        System.out.print("\nNew Print Nodes: ");
        if (temp != null) {
            temp.printNodes();
        }
    }

    /**
     * Returns the distance between 2 points
     * in the coordinate system with the formula
     * √(x1 - x2)^2 + (y1 - y2)^2
     *
     * @param x1 coordinate value of the first point
     * @param y1 coordinate value of the first point
     * @param x2 coordinate value of the second point
     * @param y2 coordinate value of the second point
     * @return Distance between 2 points
     */
    private static double distance(int x1, int y1, int x2, int y2) {
        double x = Math.pow(x2 - x1, 2);
        double y = Math.pow(y2 - y1, 2);
        return Math.sqrt(x + y);
    }


    /**
     * Calculates the distance from a specific point to the factory
     *
     * @param x coordinate of the point to be measured
     * @param y coordinate of the point to be measured
     * @return the distance from a specifically given point to the factory.
     */
    private static int distanceFromFactory(int x, int y) {
        return (int) (distance(x, y, factoryPoint[0], factoryPoint[1]) * MULTIPLIER);
    }
}
