package Bonanza.Core.Interface;

import Bonanza.Core.AbstractLayer.Player;
import Bonanza.Core.Entities.Card;

import java.util.List;

public interface IGameManager
{
	void shuffle(List<Card> cards);
	void newRound();
	void finishGame();
	void startNewGame();
	List<Player> getWinner();
	List<Card> draw(int count);
}
