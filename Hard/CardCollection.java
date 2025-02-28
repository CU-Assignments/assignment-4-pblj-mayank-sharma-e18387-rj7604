import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Card class to represent a playing card
class Card {
    private String symbol;
    private String value;

    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + " of " + symbol;
    }
}

// CardCollection class using Collection Interface
public class CardCollection {
    private List<Card> cards;

    public CardCollection() {
        cards = new ArrayList<>();
    }

    public void addCard(String symbol, String value) {
        cards.add(new Card(symbol, value));
    }

    public List<Card> findCardsBySymbol(String symbol) {
        List<Card> result = new ArrayList<>();
        for (Card card : cards) {
            if (card.getSymbol().equalsIgnoreCase(symbol)) {
                result.add(card);
            }
        }
        return result;
    }

    public void displayAllCards() {
        if (cards.isEmpty()) {
            System.out.println("No cards in the collection.");
        } else {
            System.out.println("All Stored Cards:");
            for (Card card : cards) {
                System.out.println(card);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardCollection cardCollection = new CardCollection();

        // Predefined card addition
        cardCollection.addCard("Hearts", "Ace");
        cardCollection.addCard("Spades", "King");
        cardCollection.addCard("Diamonds", "Queen");
        cardCollection.addCard("Hearts", "10");
        cardCollection.addCard("Clubs", "Jack");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Card");
            System.out.println("2. Find Cards by Symbol");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Card Symbol (Hearts, Diamonds, Clubs, Spades): ");
                    String symbol = scanner.nextLine();
                    System.out.print("Enter Card Value (e.g., Ace, 2, 3...King): ");
                    String value = scanner.nextLine();
                    cardCollection.addCard(symbol, value);
                    System.out.println("Card Added!");
                    break;

                case 2:
                    System.out.print("Enter Symbol to Search: ");
                    String searchSymbol = scanner.nextLine();
                    List<Card> foundCards = cardCollection.findCardsBySymbol(searchSymbol);
                    if (foundCards.isEmpty()) {
                        System.out.println("No cards found for symbol: " + searchSymbol);
                    } else {
                        System.out.println("Cards found:");
                        for (Card card : foundCards) {
                            System.out.println(card);
                        }
                    }
                    break;

                case 3:
                    cardCollection.displayAllCards();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
