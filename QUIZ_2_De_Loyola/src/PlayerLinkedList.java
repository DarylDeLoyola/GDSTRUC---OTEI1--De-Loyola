import java.util.Iterator;
public class PlayerLinkedList implements Iterable<Player> {

    private PlayerNode head;
    private int count = 0;

    public void add(Player player) {

        PlayerNode node = new PlayerNode(player);

        node.setNextPlayer(head);

        if (head != null) {
            head.setPreviousPlayer(node);
        }

        head = node;

        count++;
    }

    public void add(int index, Player player) {

        if (index < 0) {
            return;
        }

        if (index > count) {
            return;
        }

        if (index == 0) {
            add(player);
            return;
        }

        PlayerNode currentNode = head;

        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.getNextPlayer();
        }

        PlayerNode node = new PlayerNode(player);

        PlayerNode nextNode = currentNode.getNextPlayer();

        node.setPreviousPlayer(currentNode);
        node.setNextPlayer(nextNode);

        currentNode.setNextPlayer(node);

        if (nextNode != null) {
            nextNode.setPreviousPlayer(node);
        }

        count++;
    }

    public Player get(int index) {

        if (index < 0) {
            return null;
        }

        if (index >= count) {
            return null;
        }

        PlayerNode currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextPlayer();
        }

        return currentNode.getPlayer();
    }

    public Player removeFirst() {

        if (head == null) {
            return null;
        }

        PlayerNode removedNode = head;

        head = head.getNextPlayer();

        if (head != null) {
            head.setPreviousPlayer(null);
        }

        count--;

        return removedNode.getPlayer();
    }

    public Player remove(int index) {

        if (index < 0) {
            return null;
        }

        if (index >= count) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }

        PlayerNode currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextPlayer();
        }

        PlayerNode previousNode = currentNode.getPreviousPlayer();
        PlayerNode nextNode = currentNode.getNextPlayer();

        previousNode.setNextPlayer(nextNode);

        if (nextNode != null) {
            nextNode.setPreviousPlayer(previousNode);
        }

        count--;

        return currentNode.getPlayer();
    }

    public int size() {
        return count;
    }


    public boolean contains(Player player) {

        PlayerNode currentNode = head;

        while (currentNode != null) {

            if (currentNode.getPlayer().equals(player)) {
                return true;
            }

            currentNode = currentNode.getNextPlayer();
        }

        return false;
    }


    public int indexOf(Player player) {

        PlayerNode currentNode = head;
        int index = 0;

        while (currentNode != null) {

            if (currentNode.getPlayer().equals(player)) {
                return index;
            }

            currentNode = currentNode.getNextPlayer();
            index++;
        }

        return -1;
    }



    public void printList() {

        PlayerNode currentNode = head;

        System.out.println("HEAD");

        while (currentNode != null) {

            System.out.print(" -> " + currentNode.getPlayer());

            currentNode = currentNode.getNextPlayer();
        }

        System.out.println(" -> NULL");
    }


    // Allows the required for-each loop to work
    @Override
    public Iterator<Player> iterator() {

        return new Iterator<Player>() {

            private PlayerNode currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public Player next() {

                Player player = currentNode.getPlayer();

                currentNode = currentNode.getNextPlayer();

                return player;
            }
        };
    }
}