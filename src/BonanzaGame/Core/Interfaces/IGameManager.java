package BonanzaGame.Core.Interfaces;

import BonanzaGame.Core.AbstractPlayer;
import BonanzaGame.Entities.Card;

import java.util.List;


public interface IGameManager
{
    void shuffle(List <Card> cards);
    void newRound();
    void finishGame();
    void startNewGame();
    AbstractPlayer getWinner();
    List<Card> draw(int count);
}