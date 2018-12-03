package BonanzaGame.Core.Interfaces;

import BonanzaGame.Entities.Card;
import BonanzaGame.Core.Player;

import java.util.List;


public interface IGameManager
{
    void shuffle(List <Card> cards);
    void newRound();
    void finishGame();
    void startNewGame();
    Player getWinner();
    List<Card> draw(int count);
}
