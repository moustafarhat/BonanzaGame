package Extensions.Mafia.Core;

import BonanzaGame.Entities.Field;

public class BossPlayerJoeBohnano extends AbstractBossPlayer {

    public BossPlayerJoeBohnano() {
        harvestThreshold = 1;
        fields.add(new Field());
        this.name = "Joe Bohnano";
    }

}
