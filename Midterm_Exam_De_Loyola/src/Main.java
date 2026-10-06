import java.util.Random;
import java.util.Scanner;
public class Main {
public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //Three Stacks for Cards
        CardStack playerDeck = new CardStack(30);
        CardStack playerHand = new CardStack(30);
        CardStack discardPile = new CardStack(30);

        // Create 30 Unique Cards

        String[] cardNames = {
                "* Ace of Diamonds *", "* 2 Diamonds *", "* 3 of Diamonds *", "* 4 of Diamonds *", "* 5 of Diamonds *", "* 6 of Diamonds *",
                "* 7 of Diamonds *", "* 8 of Diamonds *", "* 9 of Diamonds *", "* 10 of Diamonds *", "* Jack of Diamonds *", "* Queen of Diamonds *",
                "* King of Diamonds *", "* Ace of Spades *", "* 2 of Spades *", "* 3 of Spaces *", "* 4 of Spades *", "* 5 of Spades *", "* 6 of Spades *",
                "* 7 of Spades *", "* 8 of Spades *", "* 9 of Spades *", "* 10 of Spades *", "* Jack of Spades *", "* Queen of Spades *", "* King of Spades *",
                "* Ace of Hearts *", "* Jack of Hearts *", "* King of Hearts *", "* Queen of Hearts *"

        };

        for (String name : cardNames) {
            Cards cards = new Cards(name);
            playerDeck.push(cards);
        }
        //Main Game Loop

        while (!playerDeck.isEmpty()) {
            System.out.println(" STARTING NEW TURN....");

            int command = random.nextInt(3);
            int amount = random.nextInt(5) + 1;

            //Draw Cards Function

            if (command == 0) {
                System.out.println(" Draw " + amount + " Cards ");

                int cardstoDraw = Math.min(amount, playerDeck.size());

                for (int i = 0; i < cardstoDraw; i++) {
                    Cards cards = playerDeck.pop();
                    playerHand.push(cards);
                }
            }


            else if (command == 1) {
                if (playerHand.isEmpty()) {
                    System.out.println(" Discard " + amount + " Cards ");
                            System.out.println (" You have no cards to Discard... ");
                        } else {
                            int cardstoDiscard = Math.min(amount, playerHand.size());

                            for(int i = 0; i < cardstoDiscard; i++) {

                                Cards cards = playerHand.pop();

                                discardPile.push(cards);
                            }

                        }
                        }

            else {
                System.out.println("Get " + amount + " Cards from Discard Pile");

                if (discardPile.isEmpty()) {
                    System.out.println("-- There are no Cards in the Discard Pile --");
                } else {
                    int cardstotake = Math.min(amount, discardPile.size());
                    for (int i = 0; i < cardstotake; i++) {
                        Cards cards = discardPile.pop();
                        playerHand.push(cards);
                    }
                }
            }

            //Gameplay Display

            System.out.println("-- Current Players Hand --");

            if (playerHand.isEmpty()) {
                System.out.println("-- Your Hand is Empty --");
            } else {
                playerHand.printstack();
            }

            System.out.println(" Cards Remaining in Deck: " + playerDeck.size());
            System.out.println(" Cards in Discard Pile: " + discardPile.size());

            // Game End
            if (playerDeck.isEmpty()) {
                System.out.println("== Your Deck is EMPTY! ==");
                System.out.println("== Game Over! ==");

                break;

            }

            System.out.println(" Press ENTER to Continue...");
            scanner.nextLine();

        }

        scanner.close();

    }
}
