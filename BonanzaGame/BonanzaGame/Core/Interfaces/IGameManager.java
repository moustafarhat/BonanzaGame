package BonanzaGame.Core.Interfaces;

import BonanzaGame.Entities.Card;
import BonanzaGame.Entities.Player;

import java.util.List;

/**
 * The interface 'IGameManager' sets up the needed methods which a concrete GameManager has to implement
 * @version 1
 * @author Moustafa Farhat , Author
 */
public interface IGameManager
{
    /**
     * Method shuffle which shuffles and randomizes the deck either at the start of the game or after the draw pile was emptied and refilled
     * @param cards are the cards to be shuffled into a random order
     */
    void shuffle(List <Card> cards);

    /**
     * Method newRound starts a new round after the last card of the deck has been drawn, also increases the round counter
     */
    void newRound();

    /**
     * Method finishGame which finalizes a game after a certain amount of rounds were played
     * Prints out the winner
     */
    void finishGame();

    /**
     * Method startNewGame which starts a new game by creating all necessary objects like Table, Players etc.
     */
    void startNewGame();

    /**
     * Method getWinner which calculates each players coins through the amount of cards in their treasury
     * The player with the most coins is determined as the winner or else the result is a draw
     * @return delivers the player instance that is the calculated winner or null when there's no winner
     */
    Player getWinner();

    /**
     * Method draw which draws cards from the Table instance
     * @param count is the amount of cards to be drawn eg. 5 starts at the start of a game, 2 at the trading phase, 3 at the drawing phase etc.
     * @return returns a list of cards from the table instance of GameManager
     */
    List<Card> draw(int count);
}
