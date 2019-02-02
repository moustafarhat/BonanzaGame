package BonanzaCore.Core.Interface;

import BonanzaCore.Core.AbstractLayer.Player;
import BonanzaCore.Core.Entities.Card;

import java.util.List;

public interface IGameManager
{
	void shuffle(List<Card> cards);
	void newRound();
	void finishGame();
	boolean startNewGame();
	List<Player> getWinner();
	List<Card> draw(int count);
}
