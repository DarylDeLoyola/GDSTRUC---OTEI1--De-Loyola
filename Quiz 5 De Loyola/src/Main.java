public class Main {
    public static void printplayers(String[] players) {
        System.out.println("CURRENT PLAYER LIST: ");

        for (int i = 0; i < players.length; i++) {
            System.out.println((i + 1) + ". " + players[i]);

        }

    }

    public static int search(String[] players, String searchtarget) {

        // DATA SET:    The Array can be both Sorted and Unsorted,
        // wherein the Linear Search does not require the elements to be arranged in any particular order

        //ALGORITHM STEPS:
            // Step 1: Starts from the first player in the array
            // Step 2: Compares the current players' name with the assigned target name
            // Step 3: If the Names, return the chosen player's index
            // Step 4: If they don't match, move to the next player
            // Step 5: Repeat until the player is found or until the array ends
            // Step 6: Lastly, if the Player is not found return -1

        //TIME COMPLEXITY:
            // Best Case: O(1) Where Player is found at the first position
            // Worst Case: O(n) Where Player is found at the last position
            //             OR if the player does not exist
            // Average Case: O(n) Each of the Elements is Checked for the chosen player

        for(int i = 0; i < players.length; i++) {

            if(players[i].equals(searchtarget)) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
         String[] players = { "Jaycee", "Reynaer", "Alex", "Daviid",
                 "Lialea", "ERIKers", "Oviler", "Isabela", "Emiriku", "Laylee", "Reyna",
                 "Rian", "Ari", "Layla", "Joshing", "Hazelea", "Justsy", "Tylus", "Darius", "Ashhley"
         };

         printplayers(players);

        String target = "ERIKers";

        // Call the search function
        int result = search(players, target);

        System.out.println();

        if (result != -1) {
            System.out.print("Player " + target + " Has Been Found!");
            System.out.println();

            System.out.println("Found at Index: " + result);
            System.out.println("Found at Position: " + (result + 1));
        } else {
            System.out.println("Player " + target + " Has not been found...");
        }

    }

}
