package Extensions.Mafia.Core.AbstractLayer;

import Bonanza.Core.AbstractLayer.AbstractTable;

import java.util.ArrayList;
import java.util.List;

public abstract class Table extends AbstractTable {

    protected List<BossPlayer> bossPlayerList;

   public Table() {
        maxPlayerCount = 4;
        bossPlayerList = new ArrayList<>();
    }

    public List<BossPlayer> getBossPlayerList() {
        return bossPlayerList;
    }
}
