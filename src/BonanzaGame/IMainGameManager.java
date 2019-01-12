package BonanzaGame;

import BonanzaGame.Core.AbstractPlayer;
import BonanzaGame.Entities.Card;

import java.util.List;

public interface IMainGameManager
{
	void shuffle(List<Card> cards);
	void newRound();
	void finishGame();
	void startNewGame();
	List<AbstractPlayer> getWinner();
	List<Card> draw(int count);
}
