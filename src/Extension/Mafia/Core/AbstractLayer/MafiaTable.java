package Extension.Mafia.Core.AbstractLayer;

import java.util.ArrayList;
import java.util.List;

public abstract class MafiaTable extends BonanzaCore.Core.AbstractLayer.Table {

    protected List<BossPlayer> bossPlayerList;

   public MafiaTable() {
        maxPlayerCount = 4;
        bossPlayerList = new ArrayList<>();
    }

    public List<BossPlayer> getBossPlayerList() {
        return bossPlayerList;
    }
}
