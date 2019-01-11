package AlCabohneExtension;

import BonanzaGame.Core.AbstractPlayer;
import BonanzaGame.Core.Enums.GameStates;
import BonanzaGame.Core.Enums.TurnPhases;
import BonanzaGame.Core.GameSettings;
import BonanzaGame.Core.Interfaces.IGameManager;
import BonanzaGame.Core.Table;
import BonanzaGame.Entities.Card;

import java.util.List;
import java.util.Random;

public class AlCabohneGameManager implements IGameManager {

    private Table _table;
    private Random _randomizer;
    private int _roundCount;
    private GameStates _gameState;
    private GameSettings _gameSettings;
    private TurnPhases _currentTurnPhase;
    private int maxRoundCount;

    @Override
    public void shuffle(List<Card> cards) {

    }

    @Override
    public void newRound() {

    }

    @Override
    public void finishGame() {

    }

    @Override
    public void startNewGame() {

    }

    @Override
    public AbstractPlayer getWinner() {
        return null;
    }

    @Override
    public List<Card> draw(int count) {
        return null;
    }
}
