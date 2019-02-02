package Extension.Mafia.Core.BossPlayers;

import BonanzaCore.Core.Entities.Field;
import Extension.Mafia.Core.AbstractLayer.BossPlayer;

public class BossPlayerJoeBohnano extends BossPlayer {

    public BossPlayerJoeBohnano() {
        harvestThreshold = 1;
        fields.add(new Field());
        this.name = "Joe Bohnano";
    }
}
