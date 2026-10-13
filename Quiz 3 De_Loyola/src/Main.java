import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        ArrayQueue queue = new ArrayQueue(10);

        String[] playerNames = {
        "Jacob", "David", "Maria", "Jason", "Erik", "Ren", "Olive", "Daniel", "Isabelle"
        ,"Emily" };

        int playerNumber = 0;
        int NumberofGames = 0;
        int turn = 0;

        System.out.println();
        System.out.println(" WELCOME TO MATHCMAKING...");
        System.out.println();

        while (NumberofGames < 10) {

            turn++;

            System.out.println("Turn: " + turn);


            //Generate 7 random Players
            int playersToAdd = random.nextInt(7) + 1;
            System.out.println();
            System.out.println(playersToAdd + " New Players Are Joining...");


            for (int i = 0; i < playersToAdd; i++) {


                String name = playerNames[playerNumber % playerNames.length];

                queue.enqueue((new Player(name)));

                playerNumber++;
            }
            System.out.println();
            System.out.println(" Players in Queue: " + queue.size());
            queue.printQueue();

            System.out.println(" Press ENTER to End Turn...");
            System.out.flush();
            scanner.nextLine();


            int currentgame = 0;

            while (queue.size() >= 5 && NumberofGames < 10){

                NumberofGames++;
                currentgame++;

                System.out.println(" New Game Has Started! Queue " + NumberofGames);
                System.out.println(" Current Players in this game: ");

                //Dequeue First 5 Players
                for (int i = 1; i <= 5; i++) {

                    Player player = queue.dequeue();
                    System.out.println( i + ". " + player.getName());

                }

                System.out.println();
                System.out.println(currentgame + " Game" + " Successfully Queued!");

            }


            System.out.println();

            //Display Number of Games started on Current turn
            System.out.println("-----Turn " + turn + " Summary-----");
            System.out.println(" Players Remaining in queue: " + queue.size());
            System.out.println(" Number of Games Started This Turn: " + currentgame);
            System.out.println(" Total Games Started: " + NumberofGames);
            System.out.println();


            //Stop After 10 games
            if (currentgame >= 10) {
                break;
            }
            if (NumberofGames == 0) {
                System.out.println(" Not Enough Players...Waiting for Next Turn... ");
                System.out.println();
            }
        }


        System.out.println(" ______________________________________ ");
        System.out.println(" Matchmaking Complete! ");
        System.out.println(" Total Games Created: " + NumberofGames);
        System.out.print(" Total Players Matched: " + (NumberofGames * 5));
        System.out.println();
        System.out.println(" Players Still Waiting for Queue: " + queue.size());
        System.out.println(" ______________________________________ ");

        scanner.close();

    }
}
