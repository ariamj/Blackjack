public class Cards
{
    // cards -> number, suit
    private int rank;
    private String suit;

    private int A = 14;
    
    private String[] ranks = {"0", "0", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    
    /** generate a card with a rank and suit
     * rank: 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A
     * suit: Diamond, Clubs, Heart, Spade */
    public Cards(int r, String s)
    {
        this.rank = r;
        this.suit = s;
    }
    
    // set value for card
    public int getValue()
    {
        if(this.rank>10)
        {
            if(this.rank==A)
            {
                return 11;
            }
            return 10;
        }
        return rank;
    }
    
    public String toString()
    {
        return ranks[rank] + suit;
    }
}
