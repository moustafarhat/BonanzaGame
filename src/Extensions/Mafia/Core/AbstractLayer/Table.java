package Extensions.Mafia.Core.AbstractLayer;

import java.util.ArrayList;
import java.util.List;

public abstract class Table extends Bonanza.Core.AbstractLayer.Table {

    protected List<BossPlayer> bossPlayerList;

   public Table() {
        maxPlayerCount = 4;
        bossPlayerList = new ArrayList<>();
    }

    public List<BossPlayer> getBossPlayerList() {
        return bossPlayerList;
    }
}
