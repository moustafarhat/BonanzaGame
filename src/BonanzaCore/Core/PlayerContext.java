package BonanzaCore.Core;

import BonanzaCore.Core.AbstractLayer.Player;
import BonanzaCore.Core.Entities.Card;

import java.util.List;

public class PlayerContext {

    private Player player;

    public void setPlayer(Player player)
    {
        this.player=player;
    }

    public  List<Card> harvest(int fieldPosition)
    {
        return player.harvest(fieldPosition);
    }
}
