import java.util.Arrays;

public class Main {

    private static final int[] startPoint = {0, 0};

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

        System.out.println("\n\n------------------------------------------\n");

        // calculate shortest path and print
        System.out.println("Shortest Path: " + calculateShortestPath(node));
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

    /**
     * Calculates the distances from the specified point to other points.
     *
     * @return the index of the point with the smallest value of these offsets.
     */
    private static int closestCusToStartPoint() {
        int indexFound = 0;
        int[] closestPoint = Main.customerPoints[0];
        double closestDist = distance(Main.startPoint[0], Main.startPoint[1],
                closestPoint[0], closestPoint[1]);

        // Traverse the array
        for (int i = 0; i < Main.customerPoints.length; i++) {
            double dist = distance(Main.startPoint[0], Main.startPoint[1],
                    Main.customerPoints[i][0], Main.customerPoints[i][1]);
            if (dist < closestDist && dist != 0.0) {
                closestDist = dist;
                indexFound = i;
            }
        }
        //return closestPoint index;
        return indexFound;
    }

    /**
     * Calculates the shortest path according to
     * whether the starting point is factory or infinity(∞).
     *
     * @param node linked list structure specifying each point
     * @return the shortest path
     */
    private static double calculateShortestPath(Node node) {
        if (Arrays.equals(startPoint, factoryPoint)) {
            return (double) (node.sumOfNodes() * 2) / MULTIPLIER;
        } else {
            // The point closest to the starting point is found
            int index = closestCusToStartPoint();
            int[] closest = customerPoints[index];
            double closestDistanceToStart = distance(startPoint[0], startPoint[1], closest[0], closest[1]);

            double factoryDisToStartCus = (double) distanceFromFactory(
                    customerPoints[index][0], customerPoints[index][1]) / MULTIPLIER;

            double totalPath = (double) (node.sumOfNodes() * 2) / MULTIPLIER;

            return totalPath - factoryDisToStartCus + closestDistanceToStart;
        }
    }
}
