package BonanzaGame.Core;

import BonanzaGame.Core.Interfaces.IGameManager;
import BonanzaGame.Entities.Card;
import BonanzaGame.Entities.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameManager implements IGameManager {
    private Table _table;

    @Override
    public void shuffle(List<Card> cards) {
        //todo
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
        try {
            this._table = new Table();
            this.shuffle(_table.drawPile());
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Player getWinner() {
        return null;
    }

    @Override
    public void endTurn(Turn currentTurn) {
    //implementation here
    }

    @Override
    public List<Card> draw(int count) {
        return null;
    }
}
