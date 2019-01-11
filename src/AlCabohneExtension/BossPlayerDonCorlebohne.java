package AlCabohneExtension;

import BonanzaGame.Entities.Field;

public class BossPlayerDonCorlebohne extends AbstractBossPlayer {

    public BossPlayerDonCorlebohne() {
        harvestThreshold = 2;
        fields.add(new Field());
        this.name = "Don Corlebohne";
    }

}
