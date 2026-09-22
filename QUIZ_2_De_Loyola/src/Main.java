import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        PlayerLinkedList linkedList = new PlayerLinkedList();

        linkedList.add(new Player(1, "Goku", 500));
        linkedList.add(new Player(2, "Saitama", 999));
        linkedList.add(new Player(3, "Sakamoto", 10));

        System.out.println(linkedList.get(1) + "\n");

        linkedList.add(2, new Player(4, "Saiki K.", 100));

        Player removedPlayer = linkedList.remove(1);
        System.out.println("Removed player: " + removedPlayer + "\n");

        System.out.println("Array size after removal: " + linkedList.size());

        boolean hasPlayer = linkedList.contains(new Player(1, "Goku", 500));
        System.out.println("Player found: " + hasPlayer + "\n");

        int playerIndex = linkedList.indexOf(new Player(4, "Saiki K.", 100));
        System.out.println("Player index: " + playerIndex + "\n");

        for (Player p : linkedList) {
            System.out.println(p);
        }
    }
}

