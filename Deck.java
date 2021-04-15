import java.util.*;

public class Deck
{
    private ArrayList<Cards> deck;
    private int count = 0;
    
    private int J = 11;
    private int Q = 12;
    private int K = 13;
    private int A = 14;
    
    private int[] rank = {0, 0, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A};
    private String[] suit = {"D", "C", "H", "S"};
    
    // create a deck of 52 cards
    public Deck()
    {
        deck = new ArrayList<Cards>();
        for(int i=0; i<4; i++)
        {
            for(int j=2; j<=A; j++)
            {
                Cards c = new Cards(rank[j], suit[i]);
                deck.add(c);
            }
        }
    }
    
    // shuffle the deck
    public void shuffleDeck()
    {
        Random r = new Random();
        for(int i=0; i<52; i++)
        {
            
            Cards c1 = deck.get(i);
            // generate random index to swap with
            int rand = r.nextInt(52);
            Cards c2 = deck.get(rand);
            // swap cards
            deck.set(i, c2);
            deck.set(rand, c1);
        }
    }
    
    // deal out the first card in the deck
    public Cards dealCard()
    {
        Cards c = deck.get(0);
        deck.remove(0);
        deck.add(c);
        count++;
        if(count<10)
        {
            shuffleDeck();
        }
        return c;
    }
    
    // print out the deck
    public ArrayList<Cards> printDeck()
    {
        return deck;
    }
}
