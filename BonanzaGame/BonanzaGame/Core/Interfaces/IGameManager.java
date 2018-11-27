package BonanzaGame.Core.Interfaces;

import BonanzaGame.Entities.Card;
import BonanzaGame.Core.Turn;
import BonanzaGame.Entities.Player;

import java.util.List;

public interface IGameManager
{
    void Shuffle();
    void newRound();
    void finishGame();
    Turn newTurn();
    void startNewGame();
    Player gerWinner();
    void endTurn(Turn cuurentTurn);
    List<Card> draw(int count);
}
