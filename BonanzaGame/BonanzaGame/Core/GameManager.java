package BonanzaGame.Core;

import BonanzaGame.Core.Interfaces.IGameManager;
import BonanzaGame.Entities.Card;
import BonanzaGame.Entities.Player;

import java.util.ArrayList;
import java.util.List;

public class GameManager implements IGameManager {
    private Table _table;

    @Override
    public void Shuffle() {
     //implementation here
    }

    @Override
    public void newRound() {
     //implementation here
    }

    @Override
    public void finishGame() {
     //implementation here
    }

    @Override
    public Turn newTurn() {
        return null;
    }

    @Override
    public void startNewGame() {
     //implementation here
        GameInitializer();
    }

    private boolean GameInitializer()
    {

        return false;
    }
    @Override
    public Player gerWinner() {
        return null;
    }

    @Override
    public void endTurn(Turn cuurentTurn) {
    //implementation here
    }

    @Override
    public List<Card> draw(int count) {
        return null;
    }
}
