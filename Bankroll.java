import java.util.*;

public class Bankroll
{
    private double betAmount = 0.0;
    private double bank;
    Scanner console;
    
    public Bankroll(double bank)
    {
        this.bank = bank;
        console = new Scanner(System.in);
    }
    
    // get an amount to bet on
    // account for invalid inputs and negative or no bets
    public void getBet()
    {
        boolean notReal;
        do
        {
            System.out.print("What is your bet?: ");
            try
            {
                notReal = false;
                betAmount = console.nextDouble();
                if(betAmount<=0.0)
                {
                    notReal = true;
                    System.out.println("Try again...");
                }
            }
            catch(InputMismatchException e)
            {
                console.next();
                notReal = true;
                System.out.println("Try again...");
            }
        } while(notReal==true);
    }
    
    // getter method for bank
    public double getBank()
    {
        return Math.round(this.bank*100)/100.0;
    }
    
    // update the bankroll amount
    public void updateBankroll(boolean win, boolean blackjack)
    {
        if(win)
        {
            this.bank += betAmount;
            // winning with blackjack gets 1.5 times bet
            if(blackjack)
            {
                this.bank += betAmount/2.0;
            }
        }
        else
        {
            this.bank -= betAmount;
        }
    }
}
