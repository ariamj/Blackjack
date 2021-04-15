import java.util.*;

public class Blackjack
{
    private Deck d;
    private Hand user;
    private Hand dealer;
    private Bankroll b;
    Scanner console;
    
    public Blackjack()
    {
        console = new Scanner(System.in);
        b = new Bankroll(100.00);
        d = new Deck();
        d.shuffleDeck();
    }
    /**
     * play the game
     */
    public void playGame()
    {
        System.out.println("Starting bankroll: $" + b.getBank());
        while(true)
        {
            b.getBet();
            // deal out two cards each
            user = new Hand();
            dealer = new Hand();
            for(int i=0; i<2; i++)
            {
                user.addCard(d.dealCard());
                dealer.addCard(d.dealCard());
            }
            // print out hands calculate hand values
            dealer.printFirstHand();
            user.printHand("Player");
            if(user.blackjack())
            {
                System.out.println("BLACKJACK!");
            }
            else
            {
                takeATurn();
            }
            System.out.print("Enter for dealer's turn... ");
            String pause = console.nextLine();
            dealerTurn();
            // determine winner and update bankroll if user wins
            determineWinner();
            // ask to play again
            if(!playAgain())
            {
                return;
            }
        }
        
    }
    /**
     * ask if user wants to play the game again
     */
    public boolean playAgain()
    {
        while(true)
        {
            System.out.print("Play again? (Y/N): ");
            String again = console.nextLine();
            if(again.equalsIgnoreCase("Y"))
            {
                System.out.println("=================");
                return true;
            }
            else if(again.equalsIgnoreCase("N"))
            {
                return false;
            }
            System.out.println("Try again...");
        }
    }
    /**
     * determine who the winner is
     */
    public void determineWinner()
    {
        int userVal = user.getValue(), dealerVal = dealer.getValue();
        boolean userBust = user.isBusted(), dealerBust = dealer.isBusted();
        // both busted; user busted & dealer not; both not & dealer > user
        if((userBust&&dealerBust)||(userBust&&!dealerBust)||((!userBust&&!dealerBust)&&dealerVal>userVal)
            ||(!user.blackjack()&&dealer.blackjack()))
        {
            // dealer wins
            System.out.println("Dealer wins!");
            b.updateBankroll(false, user.blackjack());
        }
        else if((!userBust&&dealerBust)||(!userBust&&!dealerBust)&&(userVal>dealerVal)
            ||(user.blackjack()&&!dealer.blackjack()))
        {
            // user wins
            System.out.println("Player wins!");
            b.updateBankroll(true,user.blackjack());
        }
        else
        {
            System.out.println("Push!");
        }
        System.out.println("New bankroll: $" + b.getBank());
    }
    /**
     * user takes a turn: hit or stand
     * hit -> deal a card to the player's hand
     *     -> check value for busted -> end turn
     * stand -> end turn
     */
     public void takeATurn()
     {
        while(true)
         {
             System.out.print("Would you like to hit or stand?: ");
             String action = console.nextLine();
             while(!action.equalsIgnoreCase("hit")&&!action.equalsIgnoreCase("stand"))
             {
                 System.out.print("Try again, hit or stand only: ");
                 action = console.nextLine();
             }
            if(action.equals("hit"))
            {
                user.addCard(d.dealCard());
                user.printHand("Player");
                if(user.getValue()>21)
                {
                    System.out.println("You busted!");
                    break;
                }
            }
            else
            {
                break;
            }
        }
     }
    /**
     * dealer takes a turn
     * dealer will continue to hit if hand is less than 17
     */
    public void dealerTurn()
    {
        while(true)
        {
            dealer.printHand("Dealer");
            System.out.println("Dealer's hand has value " + dealer.getValue());
            if(dealer.blackjack())
            {
                System.out.println("Dealer has BLACKJACK!");
                break;
            }
            // slow the game down with a pause
            System.out.print("Enter to continue...");
            String pause = console.nextLine();
            if(dealer.getValue()<17)
            {
                System.out.println("Dealer hits");
                Cards c = d.dealCard();
                System.out.println("Dealer's card: " + c);
                dealer.addCard(c);
                // check for whether dealer busted
                if(dealer.getValue()>21)
                {
                    System.out.println("Dealer busted!");
                    break;
                }
            }
            else if(dealer.getValue()>=17)
            {
                System.out.println("Dealer stands");
                break;
            }
        }
    }
}