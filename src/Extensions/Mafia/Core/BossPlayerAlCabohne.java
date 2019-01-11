package Extensions.Mafia.Core;

import BonanzaGame.Entities.Field;


public class BossPlayerAlCabohne extends AbstractBossPlayer {

    public BossPlayerAlCabohne() {
        harvestThreshold = 3;
        fields.add(new Field());
        this.name = "Al Cabohne";
    }

}
