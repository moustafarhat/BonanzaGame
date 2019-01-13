package BonanzaGame;

import BonanzaGame.Core.AbstractLayer.AbstractPlayer;
import BonanzaGame.Entities.Card;

import java.util.List;

public interface IGameManager
{
	void shuffle(List<Card> cards);
	void newRound();
	void finishGame();
	void startNewGame();
	List<AbstractPlayer> getWinner();
	List<Card> draw(int count);
}
