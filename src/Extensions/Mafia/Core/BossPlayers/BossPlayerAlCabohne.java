package Extensions.Mafia.Core.BossPlayers;

import BonanzaGame.Entities.Field;
import Extensions.Mafia.Core.AbstractLayer.BossPlayer;


public class BossPlayerAlCabohne extends BossPlayer {

    public BossPlayerAlCabohne() {
        harvestThreshold = 3;
        fields.add(new Field());
        this.name = "Al Cabohne";
    }
}
