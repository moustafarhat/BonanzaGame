package Extension.Mafia.Core.BossPlayers;

import BonanzaCore.Core.Entities.Field;
import Extension.Mafia.Core.AbstractLayer.BossPlayer;


public class BossPlayerAlCabohne extends BossPlayer {

    public BossPlayerAlCabohne() {
        harvestThreshold = 3;
        fields.add(new Field());
        this.name = "Al Cabohne";
    }
}
