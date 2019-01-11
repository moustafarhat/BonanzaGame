package BonanzaGame.Core.Interfaces;

import BonanzaGame.Core.AbstractPlayer;
import BonanzaGame.Entities.Card;
import BonanzaGame.IMainGameManager;

import java.util.List;


public interface IGameManager extends IMainGameManager {
    void shuffle(List <Card> cards);
    void newRound();
    void finishGame();
    void startNewGame();
    AbstractPlayer getWinner();
    List<Card> draw(int count);
}
