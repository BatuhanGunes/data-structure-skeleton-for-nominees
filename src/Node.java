public class Node {

    Node following = null;

    int data;

    public Node(int data) {
        this.data = data;
    }

    public void appendToEnd(int data) {
        Node end = new Node(data);
        Node n = this;

        while (n.following != null) {
            n = n.following;
        }
        n.following = end;
    }

    // TODO:: Implement to return the length of the SinglyLinkedList
    // For example:: --> 5 --> 6 --> 7 --> 3 --> .
    public void printNodes() {
        System.out.print(data);
        if (following != null) {
            System.out.print(" ");
            //recursively traverse the remaining nodes
            following.printNodes();
        }
    }

    // TODO:: Implement to return the length of the SinglyLinkedList
    int length(Node h) {
        int count = 0;

        //recursively traverse the nodes
        while (h != null) {
            count++;
            h = h.following;
        }
        return count;
    }

    // TODO:: Implement to return the sum of the Nodes
    int sumOfNodes() {
        int sum = 0;
        sum += data;
        Node temp = following;

        while (temp != null) {
            // accumulate sum
            sum += temp.data;

            //traverse the remaining nodes
            temp = temp.following;
        }
        return sum;
    }

    Node deleteNode(Node head, int data) {
        Node n = head;
        if (n.data == data) {
            return head.following;
        }
        // TODO:: Implement the proper loop in order to remove given data

        //
        return head;
    }
}