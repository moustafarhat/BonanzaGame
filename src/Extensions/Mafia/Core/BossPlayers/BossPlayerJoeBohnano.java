package Extensions.Mafia.Core.BossPlayers;

import BonanzaGame.Entities.Field;
import Extensions.Mafia.Core.AbstractLayer.BossPlayer;

public class BossPlayerJoeBohnano extends BossPlayer {

    public BossPlayerJoeBohnano() {
        harvestThreshold = 1;
        fields.add(new Field());
        this.name = "Joe Bohnano";
    }

}
