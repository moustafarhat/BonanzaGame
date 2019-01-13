package Bonanza.Core.Interface;

import Bonanza.Core.AbstractLayer.AbstractPlayer;
import Bonanza.Core.Entities.Card;

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
