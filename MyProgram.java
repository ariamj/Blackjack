

public class MyProgram {
    public static void main(String[] args) {
        Blackjack game = new Blackjack();
        game.playGame();
    }
}


/**
 * 2. TOP - Brainstorm top level considerations:
 * - What will the game look like?
 * <p>
 * - What are the rules?
 * <p>
 * - What needs to happen?
 * <p>
 * - What does the user do?
 * <p>
 * - How does the user win?
 * <p>
 * 3. DOWN - Classes:
 **/
// have a bankroll that can be updated
// ask for a bet
// have a deck of cards that can be shuffled
// can deal cards out
// two hands: one for player, one for dealer
// prints out the hand and value
// first deal: dealer's hand one card is hidden
// a way to choose either to hit or stand
// hit: need to deal a card out to player + update hand value
// stand: end turn
// method to determine the winner
// if either busted, blackjack or push
// update the bankroll of the player
// if blackjack: win 1.5 times bet
/**
 * - What are the rules? 
 **/
// each card is worth its number, face cards = 10, A = 1 or 11
// each new round, each person dealt 2 cards
// one of dealer's card is face down, other face up
// winning hands:
// 1. getting blackjack (i.e. value = 21)
// 2. getting higher value without going over 21
// both bust, dealer wins
// Busted: hand value > 21
// Push: hand value is equal for both player and dealer
// deal will hit until hand is greater than/equal to 17
/**
 * - What needs to happen? 
 **/
// take a bet
// hands are dealt (both dealer and player)
// value of hand calculated
// player takes a turn -> hit or stand
// hit: add a card into the hand
// hand value updated
// if value busted or = 21, end turn
// stand: end turn
// dealer takes a turn -> hit or stand
// hit until hand value is 17 or higher
// unless player busted -> then don't hit
// ~ same as player ~
// check whether either player has busted, blackjack, or push
// determine winner
// bet is updated based on who wins
// play again or not
/**
 * - What does the user do? 
 **/
// give an amount for bet
// choose whether to hit or stand -> if hit, repeat until stand
/**
 * - How does the user win? 
 **/
// 1. getting blackjack (i.e. value = 21)
// 2. getting higher value without going over 21 compared to dealer


/**
 * 3. DOWN - Classes:
 **/
// cards -> number, suit
// deck -> has cards -> shuffle, set values
// hand -> keep track of hands, update value
// bankroll -> get bet, update amount
// play blackjack -> deal
//                -> get turn action (hit/stand)
//                -> determine winner