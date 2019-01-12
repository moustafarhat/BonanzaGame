package Extensions.Mafia.Core;

import BonanzaGame.Core.AbstractTable;

import java.util.ArrayList;
import java.util.List;

public abstract class AlCabohneExtensionTable extends AbstractTable {

    protected List<AbstractBossPlayer> bossPlayerList;

    AlCabohneExtensionTable() {
        maxPlayerCount = 4;
        bossPlayerList = new ArrayList<>();
    }

    public List<AbstractBossPlayer> getBossPlayerList() {
        return bossPlayerList;
    }
}
