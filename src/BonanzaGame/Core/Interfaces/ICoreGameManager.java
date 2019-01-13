package BonanzaGame.Core.Interfaces;

import BonanzaGame.Core.AbstractLayer.AbstractPlayer;
import BonanzaGame.Entities.Card;
import BonanzaGame.IGameManager;

import java.util.List;


public interface ICoreGameManager extends IGameManager {
    void shuffle(List <Card> cards);
    void newRound();
    void finishGame();
    void startNewGame();
    List<AbstractPlayer> getWinner();
    List<Card> draw(int count);
}
