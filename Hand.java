import java.util.*;

public class Hand
{
    private ArrayList<Cards> hand;
    private int value = 0;
    
    // initialize a hand
    public Hand()
    {
        hand = new ArrayList<Cards>();
    }
    
    // add a card to the hand
    public void addCard(Cards c)
    {
        hand.add(c);
    }
    
    // get value of hand
    public int getValue()
    {
        int sum = 0;
        for(int i=0; i<hand.size(); i++)
        {
            sum += hand.get(i).getValue();
            if(hand.get(i).getValue()==11 && sum>21)
            {
                sum -= 10;
            }
        }
        return sum;
    }
    
    // Test for blackjack
    public boolean blackjack()
    {
        if(getValue()==21&&hand.size()==2)
        {
            return true;
        }
        return false;
    }
    
    // getter method for busted
    public boolean isBusted()
    {
        if(getValue()>21)
        {
            return true;
        }
        return false;
    }
    
    // print out the hand and value
    public void printHand(String player)
    {
        String str = player + ": ";
        for(int i=0; i<hand.size(); i++)
        {
            str += hand.get(i) + " ";
        }
        str += "(" + getValue() + ")";
        System.out.println(str);
    }
    
    // print the dealer's first hand -> first card is hidden
    public void printFirstHand()
    {
        String str = "Dealer: " + "X " + hand.get(1) + " (" + hand.get(1).getValue() + ")";
        System.out.println(str);
    }
}
