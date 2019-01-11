package Extensions.Mafia.Core;

import BonanzaGame.Core.AbstractPlayer;
import BonanzaGame.Entities.Card;
import Extensions.Mafia.Interface.IMafiaExtension;

import java.util.List;

public class MafiaExtension implements IMafiaExtension {
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
