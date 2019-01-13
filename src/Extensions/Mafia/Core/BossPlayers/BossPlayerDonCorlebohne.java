package Extensions.Mafia.Core.BossPlayers;

import Bonanza.Core.Entities.Field;
import Extensions.Mafia.Core.AbstractLayer.BossPlayer;

public class BossPlayerDonCorlebohne extends BossPlayer {

    public BossPlayerDonCorlebohne() {
        harvestThreshold = 2;
        fields.add(new Field());
        this.name = "Don Corlebohne";
    }
}
