package BonanzaGame.Core.Interfaces;

import BonanzaGame.Entities.Card;
import BonanzaGame.Core.Turn;
import BonanzaGame.Entities.Player;

import java.util.List;

/**
 * The interface 'IGameManager' sets up the needed methods which a concrete GameManager has to implement
 * @version 1
 * @author Moustafa Farhat , Author
 */
public interface IGameManager
{
    void shuffle(List <Card> cards);
    void newRound();
    void finishGame();
    Turn newTurn();
    void startNewGame();
    Player getWinner();
    void endTurn(Turn cuurentTurn);
    List<Card> draw(int count);
}
