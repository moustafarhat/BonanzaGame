package Extension.Mafia.Core.BossPlayers;

import BonanzaCore.Core.Entities.Field;
import Extension.Mafia.Core.AbstractLayer.BossPlayer;

public class BossPlayerDonCorlebohne extends BossPlayer {

    public BossPlayerDonCorlebohne() {
        harvestThreshold = 2;
        fields.add(new Field());
        this.name = "Don Corlebohne";
    }
}
