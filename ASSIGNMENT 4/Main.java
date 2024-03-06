import java.util.*;

class Card {
    private int suit;
    private int rank;

    // Default constructor
    public Card() {}

    // Parameterized constructor
    public Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Getter methods
    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    // Method to create a deck of cards
    public static Vector<Card> createDeck() {
        Vector<Card> deck = new Vector<>();
        for (int suit = 1; suit <= 4; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                deck.add(new Card(suit, rank));
            }
        }
        return deck;
    }

    // Method to print a card
    public void printCard() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        System.out.println(ranks[rank - 1] + " of " + suits[suit - 1]);
    }

    // Method to check if two cards are the same
    public boolean sameCard(Card other) {
        return suit == other.suit && rank == other.rank;
    }

    // Method to compare two cards
    public int compareCard(Card other) {
        if (this.rank < other.rank)
            return -1;
        else if (this.rank > other.rank)
            return 1;
        else
            return Integer.compare(this.suit, other.suit);
    }

    // Method to sort the deck of cards
    public static void sortCard(Vector<Card> deck) {
        Collections.sort(deck, new Comparator<Card>() {
            @Override
            public int compare(Card card1, Card card2) {
                return card1.compareCard(card2);
            }
        });
    }

    // Method to find a specific card in the deck
    public static boolean findCard(Vector<Card> deck, Card target) {
        for (Card card : deck) {
            if (card.sameCard(target))
                return true;
        }
        return false;
    }

    // Method to deal 5 random cards from the deck
    public static void dealCards(Vector<Card> deck) {
        if (deck.size() < 5) {
            System.out.println("Not enough cards in the deck to deal.");
            return;
        }
        Random rand = new Random();
        System.out.println("Randomly dealt cards:");
        for (int i = 0; i < 5; i++) {
            int index = rand.nextInt(deck.size());
            Card card = deck.get(index);
            card.printCard();
            deck.remove(index);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Card> deck = new Vector<>();

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Create Deck");
            System.out.println("2. Print Deck");
            System.out.println("3. Find Card");
            System.out.println("4. Sort Deck");
            System.out.println("5. Deal 5 Random Cards");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    deck = Card.createDeck();
                    System.out.println("Deck created.");
                    break;
                case 2:
                    if (deck.isEmpty()) {
                        System.out.println("Deck is empty. Please create a deck first.");
                    } else {
                        printDeck(deck);
                    }
                    break;
                case 3:
                    if (deck.isEmpty()) {
                        System.out.println("Deck is empty. Please create a deck first.");
                    } else {
                        System.out.print("Enter suit (1-4) and rank (1-13) of card to find: ");
                        int suit = scanner.nextInt();
                        int rank = scanner.nextInt();
                        Card cardToFind = new Card(suit, rank);
                        if (Card.findCard(deck, cardToFind))
                            System.out.println("Card found in the deck.");
                        else
                            System.out.println("Card not found in the deck.");
                    }
                    break;
                case 4:
                    if (deck.isEmpty()) {
                        System.out.println("Deck is empty. Please create a deck first.");
                    } else {
                        Card.sortCard(deck);
                        System.out.println("Deck sorted.");
                    }
                    break;
                case 5:
                    if (deck.isEmpty()) {
                        System.out.println("Deck is empty. Please create a deck first.");
                    } else {
                        Card.dealCards(deck);
                    }
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        } while (choice != 6);

        scanner.close();
    }

    // Method to print the entire deck
    public static void printDeck(Vector<Card> deck) {
        for (Card card : deck) {
            card.printCard();
        }
    }
}
